package com.zaot.taxcalculator;

public class CalculatorHelper {

    static int baseAccumulationFund = 25401;
    static float accumulationFundRate = 0.12f;
    static float medicalTreatmentRate = 0.02f;
    static float endowmentInsuranceRate = 0.08f;
    static float unemploymentInsuranceRate = 0.002f;

    final static float rate1 = 0.03f;
    final static float rate2 = 0.1f;
    final static float rate3 = 0.2f;
    final static float rate4 = 0.25f;
    final static float rate5 = 0.3f;
    final static float rate6 = 0.35f;
    final static float rate7 = 0.45f;

    public static String calculate(float salary, boolean isReformed) {

        int threshold1 = isReformed ? 5000 : 3500;
        int threshold2 = isReformed ? 3000 : 1500;
        int threshold3 = isReformed ? 12000 : 4500;
        int threshold4 = isReformed ? 25000 : 9000;
        int threshold5 = isReformed ? 35000 : 35000;
        int threshold6 = isReformed ? 55000 : 55000;
        int threshold7 = isReformed ? 80000 : 80000;

        float accumulationFund, medicalTreatment, endowmentInsurance, unemploymentInsurance;
        float taxSalary;
        float tax;
        float ATSalary;
        accumulationFund = Math.min(baseAccumulationFund, salary) * accumulationFundRate;
        medicalTreatment = Math.min(baseAccumulationFund, salary) * medicalTreatmentRate + 3;
        endowmentInsurance = Math.min(baseAccumulationFund, salary) * endowmentInsuranceRate;
        unemploymentInsurance = Math.min(baseAccumulationFund, salary) * unemploymentInsuranceRate;

        taxSalary =
            salary - accumulationFund - medicalTreatment - endowmentInsurance - unemploymentInsurance - threshold1;

        if (taxSalary > threshold7) {
            tax = (taxSalary - threshold7) * rate7
                + (threshold7 - threshold6) * rate6
                + (threshold6 - threshold5) * rate5
                + (threshold5 - threshold4) * rate4
                + (threshold4 - threshold3) * rate3
                + (threshold3 - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > threshold6) {
            tax = (taxSalary - threshold6) * rate6
                + (threshold6 - threshold5) * rate5
                + (threshold5 - threshold4) * rate4
                + (threshold4 - threshold3) * rate3
                + (threshold3 - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > threshold5) {
            tax = (taxSalary - threshold5) * rate5
                + (threshold5 - threshold4) * rate4
                + (threshold4 - threshold3) * rate3
                + (threshold3 - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > threshold4) {
            tax = (taxSalary - threshold4) * rate4
                + (threshold4 - threshold3) * rate3
                + (threshold3 - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > threshold3) {
            tax = (taxSalary - threshold3) * rate3
                + (threshold3 - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > threshold2) {
            tax = (taxSalary - threshold2) * rate2
                + threshold2 * rate1;
        } else if (taxSalary > 0){
            tax = taxSalary * rate1;
        } else {
            tax = 0;
        }

        ATSalary = taxSalary - tax + threshold1;
        return "公积金: " + accumulationFund + "\n"
            + "社保: " + medicalTreatment + "\n"
            + "养老保险:" + endowmentInsurance + "\n"
            + "失业保险:" + unemploymentInsurance + "\n"
            + "个税:" + tax + "\n"
            + "税后工资:" + ATSalary;
    }

}
