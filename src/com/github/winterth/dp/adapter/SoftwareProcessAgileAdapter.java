package com.github.winterth.dp.adapter;

public class SoftwareProcessAgileAdapter implements ISoftwareProcess {

    private SoftwareProcessAgileFromOtherCompany agile;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        agile = new SoftwareProcessAgileFromOtherCompany();
        agile.scrum();
    }

}
