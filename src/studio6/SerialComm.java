package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = true; // Default is to NOT be in debug mode
	}
		
	// TODO: Add writeByte() method from Studio 5
	public void writeByte(byte b) throws SerialPortException {
		port.writeByte(b);
		if (debug) {
			System.out.println(b);
		}
	}
	
	// TODO: Add available() method
	public boolean available() throws SerialPortException {
		if (port.getInputBufferBytesCount() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	// TODO: Add readByte() method	
	public byte readByte() throws SerialPortException {
		byte temp[] = port.readBytes();
		if (debug) {
			System.out.println(String.format("%02x", temp[0]));
		}
		return temp[0];
	}
	// TODO: Add a main() method
	public static void main (String[] args) throws SerialPortException {
		SerialComm por = new SerialComm("COM4");
		while (true) {
			if (por.available()) {
				System.out.println((char)por.readByte());
			}
		}
	}
}
