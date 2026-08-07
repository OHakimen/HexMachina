package com.hakimen.hex_machina;

import com.hakimen.hex_machina.common.compat.trinkets.TrinketsCompat;
import com.hakimen.hex_machina.common.registry.Registration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class HexMachina implements ModInitializer {

    public static final String MODID = "hex_machina";

    @Override
    public void onInitialize() {
        Registration.register();
        if (FabricLoader.getInstance().isModLoaded("trinkets")) {
            TrinketsCompat.register();
        }
    }
}
