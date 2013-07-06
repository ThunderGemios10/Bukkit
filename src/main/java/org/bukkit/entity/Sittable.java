package org.bukkit.entity;

public interface Sittable extends Tameable {

    /**
     * Checks if this entity is sitting.
     *
     * @return true if sitting
     */
    public boolean isSitting();

    /**
     * Sets if this entity is sitting.
     * Will remove any path that the entity was following beforehand.
     *
     * @param sitting true if sitting
     */
    public void setSitting(boolean sitting);
}
