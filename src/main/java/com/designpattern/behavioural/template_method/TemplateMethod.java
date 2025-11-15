package com.designpattern.behavioural.template_method;

public class TemplateMethod {
    public static void main(String[] args) {
        SoftwareLoader software = new MicrosoftWord();
        software.load();
        software = new MicrosoftExcel();
        software.load();
    }
}

abstract class SoftwareLoader {
    void load() {
        clearMemory();
        readLocalFiles();
        initialization();
        prepareUI();
        renderUI();
    }

    void clearMemory() {
        System.out.println("Cleaning memory...");
    }

    abstract void readLocalFiles();

    abstract void initialization();

    abstract void prepareUI();

    abstract void renderUI();
}

class MicrosoftWord extends SoftwareLoader {

    @Override
    void readLocalFiles() {
        System.out.println("Reading Microsoft Word resource files...");    
    }

    @Override
    void initialization() {
        System.out.println("Initializing Microsoft Word software...");
    }

    @Override
    void prepareUI() {
        System.out.println("Preparing Microsoft Word UI resources...");    
    }

    @Override
    void renderUI() {
        System.out.println("Rendering Microsoft Word UI...");    
    }
    
}

class MicrosoftExcel extends SoftwareLoader {

    @Override
    void readLocalFiles() {
        System.out.println("Reading Microsoft Excel resource files...");    
    }

    @Override
    void initialization() {
        System.out.println("Initializing Microsoft Excel software...");
    }

    @Override
    void prepareUI() {
        System.out.println("Preparing Microsoft Excel UI resources...");    
    }

    @Override
    void renderUI() {
        System.out.println("Rendering Microsoft Excel UI...");    
    }
    
}
