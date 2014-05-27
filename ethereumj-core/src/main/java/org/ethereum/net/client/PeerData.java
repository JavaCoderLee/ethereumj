package org.ethereum.net.client;

import org.spongycastle.util.encoders.Hex;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * www.ethereumJ.com
 * User: Roman Mandeleil
 * Created on: 13/04/14 17:36
 */
public class PeerData {

	private byte[] ip;
	private int    port;
	private byte[] peerId;

	private transient boolean isOnline = false;
	private transient long    lastCheckTime = 0;

    public PeerData(byte[] ip, int port, byte[] peerId) {
        this.ip = ip;
        this.port = port & 0xFFFF;
        this.peerId = peerId;
    }

    public InetAddress getInetAddress(){
        InetAddress addr = null;
        try {
            addr = InetAddress.getByAddress(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new Error("malformed ip");
        }
        return addr;
    }

    public byte[] getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public byte[] getPeerId() {
        return peerId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public long getLastCheckTime() {
        return lastCheckTime;
    }

    public void setLastCheckTime(long lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    @Override
    public String toString() {
        return "Peer: [ip=" + getInetAddress() + ", port=" + getPort() + ", peerId=" + Hex.toHexString(getPeerId()) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        PeerData peerData = (PeerData) obj;
        return this.getInetAddress().equals(peerData.getInetAddress());
    }

    @Override
    public int hashCode() {
        return getInetAddress().hashCode();
    }
}
