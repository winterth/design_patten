package com.github.winterth.dp.adapter;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ISoftwareProcess waterFall = new SoftwareProcessWaterfall();
        ISoftwareProcess prototyping = new SoftwareProcessPrototyping();

        ProjectA pa = new ProjectA(waterFall);
        pa.develop();
        
        ProjectB pb = new ProjectB(prototyping);
        pb.develop();

        SoftwareProcessAgileAdapter agile 
            = new SoftwareProcessAgileAdapter();
        ProjectC pc = new ProjectC(agile);
        pc.develop();

    }

}
