package others.scan_port;

public class FileStatus {
	private int accessTime;
	private int blockSize;
	private int childrenNum;
	private int fileId;
	private String group;
	private int length;
	private String modificationTime;
	private String owner;
	private String pathSuffix;
	private String permission;
	private int replication;
	private int storagePolicy;
	private String type;
	
	public int getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(int accessTime) {
		this.accessTime = accessTime;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getChildrenNum() {
		return childrenNum;
	}
	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPathSuffix() {
		return pathSuffix;
	}
	public void setPathSuffix(String pathSuffix) {
		this.pathSuffix = pathSuffix;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public int getReplication() {
		return replication;
	}
	public void setReplication(int replication) {
		this.replication = replication;
	}
	public int getStoragePolicy() {
		return storagePolicy;
	}
	public void setStoragePolicy(int storagePolicy) {
		this.storagePolicy = storagePolicy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return " [accessTime=" + accessTime + ", blockSize=" + blockSize + ", childrenNum=" + childrenNum
				+ ", fileId=" + fileId + ", group=" + group + ", length=" + length + ", modificationTime="
				+ modificationTime + ", owner=" + owner + ", pathSuffix=" + pathSuffix + ", permission=" + permission
				+ ", replication=" + replication + ", storagePolicy=" + storagePolicy + ", type=" + type + "]";
	}
	
}
