package org.bukkit.event.entity;

import org.bukkit.entity.Horse;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a horse jumps
 */
public class HorseJumpEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private float power;
    private final Horse horse;

    public HorseJumpEvent(final Horse horse, final float power) {
        super(horse);
        this.horse = horse;
        this.power = power;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    @Override
    public Horse getEntity() {
        return (Horse) entity;
    }

    /**
     * Gets the power of the jump.
     * <p>
     * Power is a value between 0.0 and 1.0 which defines how much of the
     * horse's jump strength will be used in this jump. A value of zero
     * will result in no jump, while a value of one will result in a
     * full-powered jump.
     * <p>
     * Power does not affect how high the horse is capable of jumping,
     * only how much of its jumping capability will be used in this jump.
     * To set the horse's overall jump strength, see
     * {@link Horse#setJumpStrength(double)}.
     *
     * @return jump strength
     */
    public float getPower() {
        return power;
    }

    /**
     * Sets the power of the jump.
     * <p>
     * Jump power can be set to a value above 1.0 which will increase
     * the strength of this jump above the horse's actual jump strength.
     * <p>
     * Setting the jump power to 0 will result in the jump animation
     * still playing, but the horse not leaving the ground. Only
     * cancelling this event will result in no jump animation at all.
     *
     * @param power power of the jump
     */
    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
