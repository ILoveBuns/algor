package tools;

public class DianFei {
    //上月用电示数
    private static float[] preUse = new float[]{4721.8f,4478.0f,4412.3f};
    //本月用电示数
    private static float[] nowUse = new float[]{4878.7f,4623.8f,4537.3f};
    //所有电费
    private static float allMoney = 271.62f;


    //本月实际用电
    private static float[] used = new float[]{nowUse[0]-preUse[0],nowUse[1]-preUse[1],nowUse[2]-preUse[2]};
    //公摊电费
    private static float[] shareMoney = new float[]{10,15,10};
    //除去公摊后的电费
    private static float needCalcMoney = allMoney - shareMoney[0] - shareMoney[1] - shareMoney[2];

    public static void main(String[] args) {
        System.out.println("1月电费：");
        //共用电度数
        float allUseDegree = 0;
        float[] everyUseDegree = new float[3];
        for (int i=0; i < 3; i++){
            everyUseDegree[i] = nowUse[i]-preUse[i];
            allUseDegree = allUseDegree + everyUseDegree[i];
        }
        System.out.println("用电总度数：" + (everyUseDegree[0]) + "+" + (everyUseDegree[1]) + "+" + (everyUseDegree[2]) + "=" + allUseDegree + "度");
        System.out.println();
        System.out.println("公区分摊费用:");
        for (int i = 0; i<3; i++){
            System.out.println((i+1) + "户:" + shareMoney[i] + "元");
        }

        //每户除去公摊后的费用
        float[] everyNeedPay = new float[3];
        for (int i = 0; i<3; i++){
            everyNeedPay[i] = needCalcMoney * used[i] / allUseDegree;
        }
        System.out.println();
        System.out.println("除去公区后的费用:");
        for (int i = 0; i<3; i++){
            System.out.println((i+1) + "户:（" + nowUse[i] + "-"+ preUse[i]+") / " + allUseDegree + " * " + needCalcMoney + " = " + everyNeedPay[i] + "元" );
        }

        System.out.println();
        System.out.println("总费用:");
        for (int i = 0; i<3; i++){
            System.out.println((i+1) + "户:" + shareMoney[i] + " + " + everyNeedPay[i] + " = " + (shareMoney[i] + everyNeedPay[i] ) + "元" );
        }
    }
}
