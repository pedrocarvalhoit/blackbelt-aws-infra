package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;

//É preciso passar a VPC no construtor
public class AluraClusterStack extends Stack {

    private Cluster cluster;

    //Adicionando Vpc no construtor
    public AluraClusterStack(final Construct scope, final String id, final Vpc vpc) {

        this(scope, id, null, vpc);
    }

    //Adicionando Vpc no construtor
    public AluraClusterStack(final Construct scope, final String id, final StackProps props, final Vpc vpc) {
        super(scope, id, props);

        Cluster cluster = Cluster.Builder.create(this, "AluraCluster")
                .clusterName("cluster-alura")
                .vpc(vpc)
                .build();
    }

    //Getter do cluster para ser usado no app
    public Cluster getCluster() {
        return cluster;
    }
}
