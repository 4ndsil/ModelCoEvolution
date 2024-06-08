package com.coevolution;

import java.util.ArrayList;
import java.util.List;

import com.coevolution.corelang_0_5_2.Application;
import com.coevolution.corelang_0_5_2.ConnectionRule;
import com.coevolution.corelang_0_5_2.Network;
import com.coevolution.corelang_0_5_2.RoutingFirewall;
import com.coevolution.corelang_0_5_2.SoftwareVulnerability;

public class Models {
    
    List<Model> models;

    public Models(){
        this.models = new ArrayList<>();
    }

    public Model model_1(){
        Model model = new Model();
        Network netA = new Network("NetworkA");
        Network netB = new Network("NetworkB");
        Network netC = new Network("NetworkC");
        Application app1 = new Application("Application1");
        ConnectionRule conn1 = new ConnectionRule("Connection1");
        ConnectionRule conn2 = new ConnectionRule("Connection2");
        RoutingFirewall routingfw = new RoutingFirewall("RoutingFirewall");
        SoftwareVulnerability vuln = new SoftwareVulnerability("SoftwareVulnerability");
        
        model.addAsset(netA);
        model.addAsset(netB);
        model.addAsset(netC);
        model.addAsset(app1);
        model.addAsset(conn1);
        model.addAsset(conn2);
        model.addAsset(routingfw);
        model.addAsset(vuln);

        return model;
    }

        public Model metamodel_1(){
        Model model = new Model();
        com.coevolution.corelang.Network netA = new com.coevolution.corelang.Network("NetworkA");
        com.coevolution.corelang.Application app1 = new com.coevolution.corelang.Application("Application1");
        com.coevolution.corelang.ConnectionRule conn1 = new com.coevolution.corelang.ConnectionRule("Connection1");
        com.coevolution.corelang.ConnectionRule conn2 = new com.coevolution.corelang.ConnectionRule("Connection2");
        com.coevolution.corelang.RoutingFirewall routingfw = new com.coevolution.corelang.RoutingFirewall("RoutingFirewall");
        com.coevolution.corelang.SoftwareVulnerability vuln = new com.coevolution.corelang.SoftwareVulnerability("SoftwareVulnerability");
        
        model.addAsset(netA);
        model.addAsset(app1);
        model.addAsset(conn1);
        model.addAsset(conn2);
        model.addAsset(routingfw);
        model.addAsset(vuln);

        return model;
    }
}
