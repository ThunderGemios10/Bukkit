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
         * Attempts to get the Rotation with the given value.
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
     * Get the item in this frame.
     *
     * @return The item in the frame. If there is currently no item in the frame, an ItemStack of AIR will be returned.
     *  The returned ItemStack is a defensive copy; to set the item in the frame use the
     *  {@link #setItem(ItemStack) setItem} method.
     */
    public ItemStack getItem();

    /**
     * Set the item in this frame.
     *
     * @param item The new item. A null ItemStack or an ItemStack of AIR will set the frame to have no item.
     */
    public void setItem(ItemStack item);

    /**
     * Get the rotation of the frame's item.
     *
     * @return The rotation of the item
     */
    public Rotation getRotation();

    /**
     * Set the rotation of the frame's item.
     *
     * @param rotation The new rotation
     */
    public void setRotation(Rotation rotation);
}
