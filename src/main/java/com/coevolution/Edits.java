package com.coevolution;

import java.util.ArrayList;

import com.coevolution.elements.AttackStep;
import com.coevolution.elements.Attacker;

public class Edits {

    public ArrayList<EditOperation<Class>> edits = new ArrayList<EditOperation<Class>>();

    public Edits() {     
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Application.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Application.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.ConnectionRule.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.ConnectionRule.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Credentials.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Credentials.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Data.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Data.class));
        
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Group.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Group.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Hardware.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Hardware.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.HardwareVulnerability.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.HardwareVulnerability.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Identity.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Identity.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.IDPS.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.IDPS.class));
        
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Information.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Information.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Network.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Network.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.PhysicalZone.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.PhysicalZone.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.Privileges.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.Privileges.class));
        
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.RoutingFirewall.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.RoutingFirewall.class));
        
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.SoftwareProduct.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.SoftwareProduct.class));
        
        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.SoftwareVulnerability.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.SoftwareVulnerability.class));

        edits.add(new DeleteOperation<>(com.coevolution.corelang_0_5_2.User.class));
        edits.add(new CreateOperation<>(com.coevolution.corelang.User.class));
    }
}