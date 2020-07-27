package org.terasology.metalrenegades.quests;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.math.geom.Vector3f;
import org.terasology.math.geom.Vector3i;
import org.terasology.tasks.*;

public class FetchQuest implements Quest {

    private final String shortName;
    private final String description;
    private final TaskGraph tasks;
    private final EntityRef entity;
    private Vector3f returnPoint;

    public FetchQuest(EntityRef entity, Vector3f returnPoint, String shortName, String description, TaskGraph tasks) {
        this.entity = entity;
        this.returnPoint = returnPoint;
        this.shortName = shortName;
        this.description = description;
        this.tasks = tasks;
    }

    @Override
    public EntityRef getEntity() {
        return entity;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public TaskGraph getTaskGraph() {
        return tasks;
    }

    public Vector3f getReturnPoint() { return returnPoint; }

    public void setReturnPoint(Vector3f returnPoint) {
        this.returnPoint = returnPoint;
    }

    @Override
    public Status getStatus() {
        for (Task task : tasks) {
            Status taskStatus = tasks.getTaskStatus(task);
            if (taskStatus == Status.FAILED) {
                return Status.FAILED;
            }
            if (taskStatus == Status.ACTIVE) {
                return Status.ACTIVE;
            }
        }
        return Status.SUCCEEDED;
    }

    @Override
    public String toString() {
        return String.format("FetchQuest [%s]", shortName);
    }
}
