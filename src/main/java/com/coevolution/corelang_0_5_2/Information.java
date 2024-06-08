package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Information extends Asset {
  public AttemptAccess attemptAccess;

  public Read read;

  public Write write;

  public Delete delete;

  public Deny deny;

  public Set<Data> containerData = new HashSet<>();

  public Set<Data> dataReplicas = new HashSet<>();

  public Information(String name) {
    super(name);
    assetClassName = "Information";
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
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

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("containerData")) {
      return Data.class.getName();
    } else if (field.equals("dataReplicas")) {
      return Data.class.getName();
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
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(containerData);
    assets.addAll(dataReplicas);
    return assets;
  }

  public class AttemptAccess extends AttackStepMin {
    private Set<AttackStep> _cacheParentAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccess == null) {
        _cacheParentAttemptAccess = new HashSet<>();
        for (Data _0 : containerData) {
          _cacheParentAttemptAccess.add(_0.readContainedInformation);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Information.attemptAccess");
    }
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
        for (Data _1 : dataReplicas) {
          _cacheParentRead.add(_1.read);
        }
        for (Data _2 : containerData) {
          _cacheParentRead.add(_2.extract);
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

  public class Write extends AttackStepMax {
    private Set<AttackStep> _cacheParentWrite;

    public Write(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentWrite == null) {
        _cacheParentWrite = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentWrite.add(_0.successfulWrite);
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

  public class Delete extends AttackStepMax {
    private Set<AttackStep> _cacheParentDelete;

    public Delete(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDelete == null) {
        _cacheParentDelete = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentDelete.add(_0.successfulDelete);
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

  public class Deny extends AttackStepMax {
    private Set<AttackStep> _cacheParentDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDeny == null) {
        _cacheParentDeny = new HashSet<>();
        for (Data _0 : dataReplicas) {
          _cacheParentDeny.add(_0.successfulDeny);
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
}
