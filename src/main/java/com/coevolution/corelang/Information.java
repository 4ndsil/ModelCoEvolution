package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Information extends Asset {
  public Read read;

  public Write write;

  public Delete delete;

  public Deny deny;

  public Extract extract;

  public AttemptReadFromReplica attemptReadFromReplica;

  public AttemptWriteFromReplica attemptWriteFromReplica;

  public AttemptDeleteFromReplica attemptDeleteFromReplica;

  public AttemptDenyFromReplica attemptDenyFromReplica;

  public AttemptExtractFromReplica attemptExtractFromReplica;

  public Set<Data> containerData = new HashSet<>();

  public Set<Data> dataReplicas = new HashSet<>();

  public Set<Application> dependentApps = new HashSet<>();

  public Information(String name) {
    super(name);
    assetClassName = "Information";
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(extract);
    extract = new Extract(name);
    AttackStep.allAttackSteps.remove(attemptReadFromReplica);
    attemptReadFromReplica = new AttemptReadFromReplica(name);
    AttackStep.allAttackSteps.remove(attemptWriteFromReplica);
    attemptWriteFromReplica = new AttemptWriteFromReplica(name);
    AttackStep.allAttackSteps.remove(attemptDeleteFromReplica);
    attemptDeleteFromReplica = new AttemptDeleteFromReplica(name);
    AttackStep.allAttackSteps.remove(attemptDenyFromReplica);
    attemptDenyFromReplica = new AttemptDenyFromReplica(name);
    AttackStep.allAttackSteps.remove(attemptExtractFromReplica);
    attemptExtractFromReplica = new AttemptExtractFromReplica(name);
  }

  public Information() {
    this("Anonymous");
  }

  public void addContainerData(Data containerData) {
    this.containerData.add(containerData);
    containerData.information.add(this);
  }

  public void addDataReplicas(Data dataReplicas) {
    this.dataReplicas.add(dataReplicas);
    dataReplicas.replicatedInformation.add(this);
  }

  public void addDependentApps(Application dependentApps) {
    this.dependentApps.add(dependentApps);
    dependentApps.infoDependedUpon.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("containerData")) {
      return Data.class.getName();
    } else if (field.equals("dataReplicas")) {
      return Data.class.getName();
    } else if (field.equals("dependentApps")) {
      return Application.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("containerData")) {
      assets.addAll(containerData);
    } else if (field.equals("dataReplicas")) {
      assets.addAll(dataReplicas);
    } else if (field.equals("dependentApps")) {
      assets.addAll(dependentApps);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(containerData);
    assets.addAll(dataReplicas);
    assets.addAll(dependentApps);
    return assets;
  }

  public class Read extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenRead;

    private Set<AttackStep> _cacheParentRead;

    public Read(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenRead == null) {
        _cacheChildrenRead = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheChildrenRead.add(_0.read);
        }
        for (Data _1 : containerData) {
          _cacheChildrenRead.add(_1.read);
        }
      }
      for (AttackStep attackStep : _cacheChildrenRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentRead == null) {
        _cacheParentRead = new HashSet<>();
        _cacheParentRead.add(attemptReadFromReplica);
        for (Data _2 : containerData) {
          _cacheParentRead.add(_2.read);
        }
      }
      for (AttackStep attackStep : _cacheParentRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.read");
    }
  }

  public class Write extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenWrite;

    private Set<AttackStep> _cacheParentWrite;

    public Write(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenWrite == null) {
        _cacheChildrenWrite = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheChildrenWrite.add(_0.write);
        }
        for (Data _1 : containerData) {
          _cacheChildrenWrite.add(_1.write);
        }
        for (Application _2 : dependentApps) {
          _cacheChildrenWrite.add(_2.fullAccess);
        }
        _cacheChildrenWrite.add(delete);
      }
      for (AttackStep attackStep : _cacheChildrenWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentWrite == null) {
        _cacheParentWrite = new HashSet<>();
        _cacheParentWrite.add(attemptWriteFromReplica);
        for (Data _3 : containerData) {
          _cacheParentWrite.add(_3.write);
        }
      }
      for (AttackStep attackStep : _cacheParentWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.write");
    }
  }

  public class Delete extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDelete;

    private Set<AttackStep> _cacheParentDelete;

    public Delete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDelete == null) {
        _cacheChildrenDelete = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheChildrenDelete.add(_0.delete);
        }
        for (Data _1 : containerData) {
          _cacheChildrenDelete.add(_1.delete);
        }
        _cacheChildrenDelete.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDelete == null) {
        _cacheParentDelete = new HashSet<>();
        _cacheParentDelete.add(write);
        _cacheParentDelete.add(attemptDeleteFromReplica);
        for (Data _2 : containerData) {
          _cacheParentDelete.add(_2.delete);
        }
      }
      for (AttackStep attackStep : _cacheParentDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.delete");
    }
  }

  public class Deny extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDeny;

    private Set<AttackStep> _cacheParentDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheChildrenDeny.add(_0.deny);
        }
        for (Data _1 : containerData) {
          _cacheChildrenDeny.add(_1.deny);
        }
        for (Application _2 : dependentApps) {
          _cacheChildrenDeny.add(_2.deny);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDeny == null) {
        _cacheParentDeny = new HashSet<>();
        _cacheParentDeny.add(delete);
        _cacheParentDeny.add(attemptDenyFromReplica);
        for (Data _3 : containerData) {
          _cacheParentDeny.add(_3.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.deny");
    }
  }

  public class Extract extends AttackStepMin {
    private Set<AttackStep> _cacheParentExtract;

    public Extract(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentExtract == null) {
        _cacheParentExtract = new HashSet<>();
        _cacheParentExtract.add(attemptExtractFromReplica);
        for (Data _0 : containerData) {
          _cacheParentExtract.add(_0.extract);
        }
      }
      for (AttackStep attackStep : _cacheParentExtract) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.extract");
    }
  }

  public class AttemptReadFromReplica extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReadFromReplica;

    private Set<AttackStep> _cacheParentAttemptReadFromReplica;

    public AttemptReadFromReplica(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReadFromReplica == null) {
        _cacheChildrenAttemptReadFromReplica = new HashSet<>();
        _cacheChildrenAttemptReadFromReplica.add(read);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReadFromReplica) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReadFromReplica == null) {
        _cacheParentAttemptReadFromReplica = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentAttemptReadFromReplica.add(_0.read);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReadFromReplica) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptReadFromReplica");
    }
  }

  public class AttemptWriteFromReplica extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAttemptWriteFromReplica;

    private Set<AttackStep> _cacheParentAttemptWriteFromReplica;

    public AttemptWriteFromReplica(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptWriteFromReplica == null) {
        _cacheChildrenAttemptWriteFromReplica = new HashSet<>();
        _cacheChildrenAttemptWriteFromReplica.add(write);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptWriteFromReplica) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptWriteFromReplica == null) {
        _cacheParentAttemptWriteFromReplica = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentAttemptWriteFromReplica.add(_0.write);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptWriteFromReplica) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptWriteFromReplica");
    }
  }

  public class AttemptDeleteFromReplica extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAttemptDeleteFromReplica;

    private Set<AttackStep> _cacheParentAttemptDeleteFromReplica;

    public AttemptDeleteFromReplica(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDeleteFromReplica == null) {
        _cacheChildrenAttemptDeleteFromReplica = new HashSet<>();
        _cacheChildrenAttemptDeleteFromReplica.add(delete);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDeleteFromReplica) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDeleteFromReplica == null) {
        _cacheParentAttemptDeleteFromReplica = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentAttemptDeleteFromReplica.add(_0.delete);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDeleteFromReplica) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptDeleteFromReplica");
    }
  }

  public class AttemptDenyFromReplica extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAttemptDenyFromReplica;

    private Set<AttackStep> _cacheParentAttemptDenyFromReplica;

    public AttemptDenyFromReplica(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyFromReplica == null) {
        _cacheChildrenAttemptDenyFromReplica = new HashSet<>();
        _cacheChildrenAttemptDenyFromReplica.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyFromReplica) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyFromReplica == null) {
        _cacheParentAttemptDenyFromReplica = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentAttemptDenyFromReplica.add(_0.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyFromReplica) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptDenyFromReplica");
    }
  }

  public class AttemptExtractFromReplica extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptExtractFromReplica;

    private Set<AttackStep> _cacheParentAttemptExtractFromReplica;

    public AttemptExtractFromReplica(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptExtractFromReplica == null) {
        _cacheChildrenAttemptExtractFromReplica = new HashSet<>();
        _cacheChildrenAttemptExtractFromReplica.add(extract);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptExtractFromReplica) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptExtractFromReplica == null) {
        _cacheParentAttemptExtractFromReplica = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentAttemptExtractFromReplica.add(_0.extract);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptExtractFromReplica) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptExtractFromReplica");
    }
  }
}
