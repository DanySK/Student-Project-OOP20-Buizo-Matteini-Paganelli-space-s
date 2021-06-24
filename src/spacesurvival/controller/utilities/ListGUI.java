package spacesurvival.controller.utilities;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Implements a list that returns the last and penultimate element.
 * @param <X>
 */
public class ListGUI<X> extends ArrayList<X> {
    private static final long serialVersionUID = 5136994274042052762L;

    /**
     * Get last element of the List.
     * @return Optional<X>
     */
    public Optional<X> lastElementOfList() {
        final int lastPos = 1;
        return Optional.of(super.get(super.size() - lastPos));
    }

    /**
     * Get penultimate element of the List.
     * @return Optional<X>
     */
    public Optional<X> penultimateElementOfList() {
        final int penultimatePos = 2;
        return Optional.of(super.get(super.size() - penultimatePos));
    }


}
