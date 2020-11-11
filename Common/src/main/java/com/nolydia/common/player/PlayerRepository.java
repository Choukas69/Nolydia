package com.nolydia.common.player;

import java.util.UUID;

public interface PlayerRepository {

    Player getPlayer(UUID uuid);
}
