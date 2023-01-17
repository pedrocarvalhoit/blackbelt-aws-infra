package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();

        //Iniciando a Vpc na aplicação
        AluraVpcStack vpcStack = new AluraVpcStack(app, "Vpc");

        //Iniciando Cluster
        AluraClusterStack clusterStack = new AluraClusterStack(app, "Cluster", vpcStack.getVpc());
        //Esta dependecia obriga que primeiro seja criada a vpc, para que possa ser criado o cluster
        clusterStack.addDependency(vpcStack);

        AluraServiceStack aluraServiceStack = new AluraServiceStack(app, "Service", clusterStack.getCluster());
        //Esta dependecia obriga que primeiro seja criada o cluster, para que possa ser criado o service
        aluraServiceStack.addDependency(clusterStack);

        app.synth();
    }
}

