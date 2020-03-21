package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        var copiedArray = sadArray.toMutableList()
        if(copiedArray.size < 2){
            return sadArray
        }

        var isHappy: Boolean = false
        var happyCounter: Int

        while (!isHappy){
            happyCounter = 2 // first and last elements always happy
            for (i in 1 until copiedArray.size-1){

                if (!checkIsHappy(copiedArray[i-1], copiedArray[i], copiedArray[i+1])){
                    copiedArray.removeAt(i)
                    break
                }

                happyCounter++
            }

            if (happyCounter == copiedArray.size){
                isHappy = true
            }
        }


        return copiedArray.toIntArray()
    }

    private fun checkIsHappy(leftElem: Int, currElem: Int, rightElem: Int): Boolean {
        return leftElem + rightElem > currElem
    }

}
