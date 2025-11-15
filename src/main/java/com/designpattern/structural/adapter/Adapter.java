package com.designpattern.structural.adapter;

public class Adapter {
    public static void main(String[] args) {
        AppV1Service appV1 = new AppV1Service();
        appV1.process(new V1Spec());

        AppV2Adapter adapter = new AppV2Adapter();
        adapter.process(new V1Spec());
    }
}

interface AppV1 {
    public void process(V1Spec spec);
}

class V1Spec {
    public final String VERSION = "v1.0.0";
}

class AppV1Service implements AppV1 {
    public void process(V1Spec spec) {
        System.out.println(String.format("Processing %s service", spec.VERSION));
    }
}

class V2Spec {
    public final String VERSION = "v2.0.0";
    V2Spec(V1Spec spec) {
        System.out.println(String.format("Convert spec from %s to %s", spec.VERSION, this.VERSION));
    }
}

class AppV2Service {
    public void process(V2Spec spec) {
        System.out.println(String.format("Processing %s service", spec.VERSION));
    }
}

class AppV2Adapter implements AppV1 {
    private AppV2Service service;
    public AppV2Adapter() {
        this.service = new AppV2Service();
    }

    @Override
    public void process(V1Spec spec) {
        service.process(convertSpec(spec));
    }

    private V2Spec convertSpec(V1Spec spec) {
        return new V2Spec(spec);
    }

}
