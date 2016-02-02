package com.github.winterth.dp.adapter;

public class ProjectB extends ProjectAbstract {

    
    public ProjectB(ISoftwareProcess process) {
        super.process = process;
    }
    @Override
    public void develop() {
        // TODO Auto-generated method stub
        System.out.println("Developing ProjectB");
        process.run();

    }

}
