
package com.sk89q.worldedit.masks;

import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.Vector;

public abstract class AbstractMask implements Mask {
	@Override
	public void prepare(LocalSession session, LocalPlayer player, Vector target) {}
}
