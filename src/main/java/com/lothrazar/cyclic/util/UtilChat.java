package com.lothrazar.cyclic.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class UtilChat {

  public static void addChatMessage(PlayerEntity player, String message) {
    if (player.world.isRemote) {
      player.sendMessage(new TranslationTextComponent((message)));
    }
  }

  public static String blockPosToString(BlockPos pos) {
    return pos.getX() + ", " + pos.getY() + ", " + pos.getZ();
  }

  public static void sendStatusMessage(PlayerEntity player, String message) {
    player.sendStatusMessage(new TranslationTextComponent(message), true);
  }

  public static void sendStatusMessage(PlayerEntity player, ITextComponent nameTextComponent) {
    if (player.world.isRemote) {
      player.sendStatusMessage(nameTextComponent, true);
    }
  }

  public static String lang(String message) {
    TranslationTextComponent t = new TranslationTextComponent(message);
    return t.getFormattedText();
  }
}
