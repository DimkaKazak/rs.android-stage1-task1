package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var BrianBill =  bill.sum() / 2
        var AnnBill = BrianBill - bill[k] / 2

        if( AnnBill == b){
            return "Bon Appetit"
        }

        return (kotlin.math.abs(AnnBill - b)).toString()
    }
}
