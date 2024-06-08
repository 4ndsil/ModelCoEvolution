package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class SoftwareProduct extends Information {
  public CompromiseApplications compromiseApplications;

  public ReadApplications readApplications;

  public ModifyApplications modifyApplications;

  public DenyApplications denyApplications;

  public Set<Application> softApplications = new HashSet<>();

  public Set<SoftwareVulnerability> softProductVulnerabilities = new HashSet<>();

  public SoftwareProduct(String name) {
    super(name);
    assetClassName = "SoftwareProduct";
    AttackStep.allAttackSteps.remove(compromiseApplications);
    compromiseApplications = new CompromiseApplications(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(readApplications);
    readApplications = new ReadApplications(name);
    AttackStep.allAttackSteps.remove(modifyApplications);
    modifyApplications = new ModifyApplications(name);
    AttackStep.allAttackSteps.remove(denyApplications);
    denyApplications = new DenyApplications(name);
  }

  public SoftwareProduct() {
    this("Anonymous");
  }

  public void addSoftApplications(Application softApplications) {
    this.softApplications.add(softApplications);
    softApplications.appSoftProduct = this;
  }

  public void addSoftProductVulnerabilities(SoftwareVulnerability softProductVulnerabilities) {
    this.softProductVulnerabilities.add(softProductVulnerabilities);
    softProductVulnerabilities.softwareProduct = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("softApplications")) {
      return Application.class.getName();
    } else if (field.equals("softProductVulnerabilities")) {
      return SoftwareVulnerability.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("softApplications")) {
      assets.addAll(softApplications);
    } else if (field.equals("softProductVulnerabilities")) {
      assets.addAll(softProductVulnerabilities);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(softApplications);
    assets.addAll(softProductVulnerabilities);
    return assets;
  }

  public class CompromiseApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromiseApplications;

    private Set<AttackStep> _cacheParentCompromiseApplications;

    public CompromiseApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromiseApplications == null) {
        _cacheChildrenCompromiseApplications = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenCompromiseApplications.add(_0.attemptFullAccessFromSupplyChainCompromise);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromiseApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCompromiseApplications == null) {
        _cacheParentCompromiseApplications = new HashSet<>();
        _cacheParentCompromiseApplications.add(write);
      }
      for (AttackStep attackStep : _cacheParentCompromiseApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.compromiseApplications");
    }
  }

  public class Write extends Information.Write {
    private Set<AttackStep> _cacheChildrenWrite;

    public Write(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenWrite == null) {
        _cacheChildrenWrite = new HashSet<>();
        _cacheChildrenWrite.add(compromiseApplications);
      }
      for (AttackStep attackStep : _cacheChildrenWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.write");
    }
  }

  public class ReadApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenReadApplications;

    private Set<AttackStep> _cacheParentReadApplications;

    public ReadApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadApplications == null) {
        _cacheChildrenReadApplications = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenReadApplications.add(_0.attemptReadFromSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReadApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadApplications == null) {
        _cacheParentReadApplications = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentReadApplications.add(_1.read);
        }
      }
      for (AttackStep attackStep : _cacheParentReadApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.readApplications");
    }
  }

  public class ModifyApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenModifyApplications;

    private Set<AttackStep> _cacheParentModifyApplications;

    public ModifyApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyApplications == null) {
        _cacheChildrenModifyApplications = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenModifyApplications.add(_0.attemptModifyFromSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenModifyApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyApplications == null) {
        _cacheParentModifyApplications = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentModifyApplications.add(_1.modify);
        }
      }
      for (AttackStep attackStep : _cacheParentModifyApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.modifyApplications");
    }
  }

  public class DenyApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenyApplications;

    private Set<AttackStep> _cacheParentDenyApplications;

    public DenyApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyApplications == null) {
        _cacheChildrenDenyApplications = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenDenyApplications.add(_0.attemptDenyFromSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenyApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyApplications == null) {
        _cacheParentDenyApplications = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentDenyApplications.add(_1.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.denyApplications");
    }
  }
}
