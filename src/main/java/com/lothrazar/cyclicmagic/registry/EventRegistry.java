package com.lothrazar.cyclicmagic.registry;
import java.util.ArrayList;
import com.lothrazar.cyclicmagic.component.playerextensions.EventExtendedInventory;
import com.lothrazar.cyclicmagic.component.playerextensions.EventGuiInvoButtons;
import com.lothrazar.cyclicmagic.config.EventConfigChanged;
import com.lothrazar.cyclicmagic.event.EventAchievement;
import com.lothrazar.cyclicmagic.event.EventKeyInput;
import com.lothrazar.cyclicmagic.event.EventPlayerData;
import com.lothrazar.cyclicmagic.potion.EventPotionTick;
import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {
  private ArrayList<Object> events = new ArrayList<Object>();
  public void registerCoreEvents() {
    this.register(new EventAchievement());
    this.register(new EventConfigChanged());
    this.register(new EventExtendedInventory());
    this.register(new EventKeyInput());
    this.register(new EventPlayerData());
    this.register(new EventGuiInvoButtons());
    this.register(new EventPotionTick());
  }
  public void register(Object e) {
    events.add(e);
  }
  public void registerAll() {
    for (Object e : events) {
      MinecraftForge.EVENT_BUS.register(e);
    }
  }
}
