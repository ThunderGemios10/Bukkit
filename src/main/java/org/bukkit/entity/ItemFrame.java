package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;

/**
 * Represents an Item Frame
 */
public interface ItemFrame extends Hanging {
    /**
     * An enum to specify the rotation of the ItemFrame's item
     */
    public enum Rotation {
        /**
         * No rotation
         */
        NONE,
        /**
         * Rotated clockwise
         */
        CLOCKWISE,
        /**
         * Flipped upside-down
         */
        FLIPPED,
        /**
         * Rotated counter-clockwise
         */
        COUNTER_CLOCKWISE;

        private static final Rotation [] rotations = values();

        /**
         * Rotate clockwise one value, as if the frame was right-clicked by a player.
         *
         * @return The new rotation
         */
        public Rotation rotateClockwise() {
            return rotations[(this.ordinal() + 1) & 0x3];
        }

        /**
         * Attempts to get the Rotation with the given value
         *
         * @param value Value of the Rotation to get
         * @return Rotation if found, or null
         */
        public static Rotation getRotation(final int value) {
            if (rotations.length > value) {
                return rotations[value];
            } else {
                return null;
            }
        }
    }

    /**
     * Get the item in this frame
     *
     * @return The item
     */
    public ItemStack getItem();

    /**
     * Set the item in this frame
     *
     * @param item The new item
     */
    public void setItem(ItemStack item);

    /**
     * Get the rotation of the frame's item
     *
     * @return The direction
     */
    public Rotation getRotation();

    /**
     * Set the rotation of the frame's item
     *
     * @param rotation The new rotation
     */
    public void setRotation(Rotation rotation);
}
