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
package org.terasology.rails.trains.blocks.components;

import org.terasology.entitySystem.Component;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.network.Replicate;

import javax.vecmath.Vector3f;
import java.util.List;

public class TrainRailComponent implements Component {
    @Replicate
    public static enum TrackType {STRAIGHT, UP, DOWN, LEFT, RIGHT, CUSTOM};
    public TrackType type;
    public Vector3f startPosition;
    public Vector3f endPosition;
    public float yaw;
    public float pitch;
    public float roll;
    public EntityRef prevTrack = EntityRef.NULL;
    public EntityRef nextTrack = EntityRef.NULL;
    public String chunkKey;
}
