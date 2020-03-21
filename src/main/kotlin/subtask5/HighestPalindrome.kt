package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        if (checkIsPalindrome(digitString)) return digitString
        if (!checkHaveEnoughPermutations(k, digitString)) return "-1"

        var resultString = digitString.toMutableList()
        var numOfRemainingK = k
        for (i in 0 until resultString.size / 2){
            val left = resultString[i]
            val right = resultString[resultString.size - (i + 1)]
            if (left != right){

                if ( checkLeftDigitIsLarger(left, right) ){
                    resultString[resultString.size - (i + 1)] = resultString[i]
                } else{
                    resultString[i] = resultString[resultString.size - (i + 1)]
                }
                numOfRemainingK--
            }
        }

        var currIndex = 0
        while (numOfRemainingK != 0){
            if (resultString[currIndex] != '9'){
                resultString[currIndex] = '9'
                resultString[resultString.size - (currIndex + 1)] = '9'
            }
            currIndex++
            numOfRemainingK--
        }

        return resultString.joinToString(separator = "")
    }

    private fun checkLeftDigitIsLarger(digitLeft: Char, digitRight: Char): Boolean{
        return digitLeft.toInt() > digitRight.toInt()
    }

    private fun checkIsPalindrome(digitString: String): Boolean {
        for (i in 0 until digitString.length / 2){
            if (digitString[i] != digitString[digitString.length - (i + 1)]) return false
        }
        return true
    }

    private fun checkHaveEnoughPermutations(k: Int, digitString: String): Boolean {
        var counter = 0
        for (i in 0 until digitString.length / 2){
            if (digitString[i] != digitString[digitString.length - (i + 1)]) counter++
        }
        return k >= counter
    }
}
