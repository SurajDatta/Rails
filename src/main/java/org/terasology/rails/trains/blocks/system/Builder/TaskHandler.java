/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rails.trains.blocks.system.Builder;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.rails.trains.blocks.components.TrainRailComponent;
import org.terasology.rails.trains.blocks.system.Misc.Orientation;
import org.terasology.rails.trains.blocks.system.Tasks.Task;

import javax.vecmath.Vector3f;

/**
 * Created by adeon on 09.09.14.
 */
public class TaskHandler {
    public boolean start(Task task, EntityRef selectedTrack, Vector3f position, Orientation orientation, boolean preview) {
        if (!selectedTrack.equals(EntityRef.NULL) && !selectedTrack.hasComponent(TrainRailComponent.class)) {
            return false;
        }

        TrainRailComponent trainRailComponent = selectedTrack.getComponent(TrainRailComponent.class);

        if (!selectedTrack.equals(EntityRef.NULL) && !trainRailComponent.nextTrack.equals(EntityRef.NULL) && !trainRailComponent.prevTrack.equals(EntityRef.NULL)) {
            return false;
        }

        return runTask(task, selectedTrack, position, orientation, preview);
    }

    private boolean runTask(Task task, EntityRef track, Vector3f position, Orientation orientation, boolean preview) {
        return task.run(track, position, orientation, preview);
    }
}
