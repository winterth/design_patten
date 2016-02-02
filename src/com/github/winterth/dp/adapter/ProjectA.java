package com.github.winterth.dp.adapter;

public class ProjectA extends ProjectAbstract {

    
    public ProjectA(ISoftwareProcess process) {
        super.process = process;
    }
    @Override
    public void develop() {
        // TODO Auto-generated method stub
        System.out.println("Developing ProjectA");
        process.run();

    }

}
