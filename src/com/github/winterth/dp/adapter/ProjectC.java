package com.github.winterth.dp.adapter;

public class ProjectC extends ProjectAbstract {

    public ProjectC(ISoftwareProcess process) {
        super.process = process;
    }
    @Override
    public void develop() {
        // TODO Auto-generated method stub
        System.out.println("Developing ProjectC");
        process.run();

    }
}
