
package com.sk89q.wepif;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class TestOfflinePermissible implements OfflinePlayer, Permissible {
	private boolean op;
	
	private final Map<String, Boolean> assignedPermissions = new HashMap<String, Boolean>();
	
	@Override
	public boolean isOp() {
		return op;
	}
	
	@Override
	public void setOp(boolean b) {
		this.op = b;
	}
	
	@Override
	public boolean isPermissionSet(String s) {
		return assignedPermissions.containsKey(s.toLowerCase());
	}
	
	@Override
	public boolean isPermissionSet(Permission permission) {
		return isPermissionSet(permission.getName());
	}
	
	@Override
	public boolean hasPermission(String s) {
		if (isPermissionSet(s)) return assignedPermissions.get(s.toLowerCase());
		return false;
	}
	
	@Override
	public boolean hasPermission(Permission permission) {
		return hasPermission(permission.getName());
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void recalculatePermissions() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		Set<PermissionAttachmentInfo> ret = new HashSet<PermissionAttachmentInfo>();
		for (Map.Entry<String, Boolean> entry : assignedPermissions.entrySet()) {
			ret.add(new PermissionAttachmentInfo(this, entry.getKey(), null, entry.getValue()));
		}
		return ret;
	}
	
	public void setPermission(String permission, boolean value) {
		assignedPermissions.put(permission.toLowerCase(), value);
	}
	
	public void unsetPermission(String permission) {
		assignedPermissions.remove(permission.toLowerCase());
	}
	
	public void clearPermissions() {
		assignedPermissions.clear();
	}
	
	// -- Unneeded OfflinePlayer methods
	
	@Override
	public boolean isOnline() {
		return false;
	}
	
	@Override
	public String getName() {
		return "Tester";
	}
	
	@Override
	public boolean isBanned() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void setBanned(boolean b) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public boolean isWhitelisted() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void setWhitelisted(boolean b) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public Player getPlayer() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public long getFirstPlayed() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public long getLastPlayed() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public boolean hasPlayedBefore() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public Location getBedSpawnLocation() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public Map<String, Object> serialize() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
