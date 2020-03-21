package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {

        var container = arrayOf('[','(','<','>',')',']')
        var charList =  mutableListOf<Char>()
        var posOfChar = mutableListOf<Int>()

        for (i in inputString.indices) {
            if(inputString[i] in container){
                charList.add(inputString[i])
                posOfChar.add(i)
            }
        }

        var result = mutableListOf<String>()
        var lastIndex: Int = 0

        for (i in 0 until charList.size){
            when(charList[i]){
                '<' -> {
                    lastIndex = findChar(charList, '>', i)
                    if (lastIndex != -1) result.add(inputString.substring(posOfChar[i] + 1,
                        posOfChar[lastIndex]))
                }

                '(' -> {
                    lastIndex = findChar(charList, ')', i)
                    if(lastIndex != -1) result.add(inputString.substring(posOfChar[i] + 1,
                        posOfChar[lastIndex]))
                }

                '[' -> {
                    lastIndex = findChar(charList, ']', i)
                    if (lastIndex != -1) result.add(inputString.substring(posOfChar[i] + 1,
                        posOfChar[lastIndex]))
                }

            }
        }

        return result.toTypedArray()
    }

    private fun findChar(charList: MutableList<Char>, charToFind: Char, fromPos: Int): Int{
        var counterOfSameChar = 0
        for (j in fromPos until charList.size){

            if(charList[j] == charList[fromPos]) counterOfSameChar++

            if(charList[j] == charToFind){
                if(counterOfSameChar == 1){
                    charList[fromPos] = '.'
                    charList[j] = '.'
                    return j
                } else counterOfSameChar--
            }

        }
        return -1
    }

}

