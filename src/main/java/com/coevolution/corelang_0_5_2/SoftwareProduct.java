package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class SoftwareProduct extends Information {
  public CompromiseApplication compromiseApplication;

  public ReadApplication readApplication;

  public ModifyApplication modifyApplication;

  public DenyApplication denyApplication;

  public Set<SoftwareVulnerability> softProductVulnerabilities = new HashSet<>();

  public Set<Application> softApplications = new HashSet<>();

  public Data originData = null;

  public SoftwareProduct(String name) {
    super(name);
    assetClassName = "SoftwareProduct";
    AttackStep.allAttackSteps.remove(compromiseApplication);
    compromiseApplication = new CompromiseApplication(name);
    AttackStep.allAttackSteps.remove(readApplication);
    readApplication = new ReadApplication(name);
    AttackStep.allAttackSteps.remove(modifyApplication);
    modifyApplication = new ModifyApplication(name);
    AttackStep.allAttackSteps.remove(denyApplication);
    denyApplication = new DenyApplication(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
  }

  public SoftwareProduct() {
    this("Anonymous");
  }

  public void addSoftProductVulnerabilities(SoftwareVulnerability softProductVulnerabilities) {
    this.softProductVulnerabilities.add(softProductVulnerabilities);
    softProductVulnerabilities.softwareProduct = this;
  }

  public void addSoftApplications(Application softApplications) {
    this.softApplications.add(softApplications);
    softApplications.appSoftProduct = this;
  }

  public void addOriginData(Data originData) {
    this.originData = originData;
    originData.originSoftwareProduct = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("softProductVulnerabilities")) {
      return SoftwareVulnerability.class.getName();
    } else if (field.equals("softApplications")) {
      return Application.class.getName();
    } else if (field.equals("originData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("softProductVulnerabilities")) {
      assets.addAll(softProductVulnerabilities);
    } else if (field.equals("softApplications")) {
      assets.addAll(softApplications);
    } else if (field.equals("originData")) {
      if (originData != null) {
        assets.add(originData);
      }
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(softProductVulnerabilities);
    assets.addAll(softApplications);
    if (originData != null) {
      assets.add(originData);
    }
    return assets;
  }

  public class CompromiseApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromiseApplication;

    private Set<AttackStep> _cacheParentCompromiseApplication;

    public CompromiseApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromiseApplication == null) {
        _cacheChildrenCompromiseApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenCompromiseApplication.add(_0.attemptFullAccessAfterSoftProdCompromise);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromiseApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCompromiseApplication == null) {
        _cacheParentCompromiseApplication = new HashSet<>();
        _cacheParentCompromiseApplication.add(write);
        if (originData != null) {
          _cacheParentCompromiseApplication.add(originData.compromiseAppOrigin);
        }
      }
      for (AttackStep attackStep : _cacheParentCompromiseApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.compromiseApplication");
    }
  }

  public class ReadApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenReadApplication;

    private Set<AttackStep> _cacheParentReadApplication;

    public ReadApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadApplication == null) {
        _cacheChildrenReadApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenReadApplication.add(_0.attemptReadAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReadApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadApplication == null) {
        _cacheParentReadApplication = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentReadApplication.add(_1.read);
        }
      }
      for (AttackStep attackStep : _cacheParentReadApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.readApplication");
    }
  }

  public class ModifyApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenModifyApplication;

    private Set<AttackStep> _cacheParentModifyApplication;

    public ModifyApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyApplication == null) {
        _cacheChildrenModifyApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenModifyApplication.add(_0.attemptModifyAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenModifyApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyApplication == null) {
        _cacheParentModifyApplication = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentModifyApplication.add(_1.modify);
        }
      }
      for (AttackStep attackStep : _cacheParentModifyApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.modifyApplication");
    }
  }

  public class DenyApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenyApplication;

    private Set<AttackStep> _cacheParentDenyApplication;

    public DenyApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyApplication == null) {
        _cacheChildrenDenyApplication = new HashSet<>();
        for (Application _0 : softApplications) {
          _cacheChildrenDenyApplication.add(_0.attemptDenyAfterSoftProdVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenyApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyApplication == null) {
        _cacheParentDenyApplication = new HashSet<>();
        for (SoftwareVulnerability _1 : softProductVulnerabilities) {
          _cacheParentDenyApplication.add(_1.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("SoftwareProduct.denyApplication");
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
        _cacheChildrenWrite.add(compromiseApplication);
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
}
