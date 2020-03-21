package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
        var summ: Int = input.sum()

        val summList: MutableList<Int> = mutableListOf()
        input.forEach {
            summList.add(summ - it)
        }

        val min = summList.min()
        val max = summList.max()
        if(checkNullable(min) && checkNullable(max)){
            return intArrayOf(min!!, max!!)
        }
        return intArrayOf()
    }

    private fun checkNullable(num: Int?): Boolean{
        if (num != null){
            return true
        }
        return false
    }
}
