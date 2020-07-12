/*
 * Copyright 2019 MovingBlocks
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
package org.terasology.metalrenegades.economy.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Creates a MarketItem object based on the provided data
 */
public final class MarketItemBuilder {

    private static final String DEFAULT_ITEM = "default";
    private static final String EMPTY = "empty";
    private static Map<String, MarketItem> details = new HashMap<>();
    private static boolean isInitialised = false;

    private static void initialise() {
        details.put("AdditionalFruits:Blueberry", new MarketItem(
                "AdditionalFruits:Blueberry",
                "Blueberries",
                "Blue/purple berries, perfect for a quick treat!",
                2,
                false
        ));

        details.put("AdditionalFruits:Cranberry", new MarketItem(
                "AdditionalFruits:Cranberry",
                "Cranberries",
                "Small berries, with an incredible red hue.",
                2,
                false
        ));

        details.put("AdditionalFruits:Peach", new MarketItem(
                "AdditionalFruits:Peach",
                "Peaches",
                "A medium-sized pink fruit; nice and juicy!",
                2,
                false
        ));

        details.put("AdditionalFruits:Raspberry", new MarketItem(
                "AdditionalFruits:Raspberry",
                "Raspberries",
                "A small red berry, or is it really a bunch of smaller berries?",
                2,
                false
        ));

        details.put("AdditionalFruits:Strawberry", new MarketItem(
                "AdditionalFruits:Strawberry",
                "Strawberries",
                "A delicious red berry with an outer layer of seeds.",
                2,
                false
        ));

        details.put("AdditionalFruits:Tomato", new MarketItem(
                "AdditionalFruits:Tomato",
                "Tomatoes",
                "A medium-size red vegetable/fruit.",
                2,
                false
        ));

        details.put("AdditionalVegetables:Cucumber", new MarketItem(
                "AdditionalVegetables:Cucumber",
                "Cucumbers",
                "A long green vegetable, delicious to eat in slices!",
                2,
                false
        ));

        details.put("AdditionalVegetables:Potato", new MarketItem(
                "AdditionalVegetables:Potato",
                "Potatoes",
                "A brownish root vegetable, and a major ingredient in French Fries!",
                2,
                false
        ));

        details.put("CoreAssets:Torch", new MarketItem(
                "CoreAssets:Torch",
                "Torches",
                "Great for lighting up a room!",
                2,
                true
        ));

        details.put("CoreAssets:pickaxe", new MarketItem(
                "CoreAssets:pickaxe",
                "Pickaxe",
                "There's gold in them hills, and this tool will bring you to it.",
                2,
                true
        ));

        details.put(EMPTY, new MarketItem(
                "",
                "",
                "",
                0,
                false
        ));

        isInitialised = true;
    }

    public static MarketItem getDefault() {
        if (!isInitialised) {
            initialise();
        }
        return details.get(DEFAULT_ITEM);
    }

    public static MarketItem getEmpty() {
        if (!isInitialised) {
            initialise();
        }
        return details.get(EMPTY);
    }

    public static MarketItem get(String name, int quantity) {
        if (!isInitialised) {
            initialise();
        }

        MarketItem item = details.get(name);
        if (item == null) {
            item = tryCreate(name);
        }

        if  (item == null) {
            item = details.get(DEFAULT_ITEM);
        }

        item.quantity = quantity;
        item.buyable = true;
        item.sellable = false;
        return item;
    }

    private static MarketItem tryCreate(String name) {
        Random random = new Random();
        MarketItem item = new MarketItem(
                name,
                name,
                "A mystery item. No description is available",
                random.nextInt(50),
                false
        );
        details.put(name, item);
        return item;
    }
}
