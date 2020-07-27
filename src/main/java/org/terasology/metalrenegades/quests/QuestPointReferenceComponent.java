package org.terasology.metalrenegades.quests;

import org.terasology.entitySystem.Component;
import org.terasology.entitySystem.entity.EntityRef;

public class QuestPointReferenceComponent implements Component {

    public EntityRef questPoint;

    public QuestPointReferenceComponent() {

    }

    public QuestPointReferenceComponent(EntityRef questPoint) {
        this.questPoint = questPoint;
    }

}
