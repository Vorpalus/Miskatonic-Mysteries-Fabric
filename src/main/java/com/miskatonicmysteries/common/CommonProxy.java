package com.miskatonicmysteries.common;

import com.miskatonicmysteries.lib.ModObjects;
import com.miskatonicmysteries.lib.ModRecipes;
import net.fabricmc.api.ModInitializer;

public class CommonProxy implements ModInitializer {
    //todo, data driven stuff
    @Override
    public void onInitialize() {
        ModObjects.init();
        ModRecipes.init();
    }
}
