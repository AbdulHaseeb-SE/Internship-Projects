package urraan.internship.chapter2_loginpage

fun isTextfieldEmpty (vararg textfields : String): Boolean{
    var check = false
    for (items in textfields){
        if (items.isEmpty())
        {
            check = true
            break
        }
    }
    return check
}