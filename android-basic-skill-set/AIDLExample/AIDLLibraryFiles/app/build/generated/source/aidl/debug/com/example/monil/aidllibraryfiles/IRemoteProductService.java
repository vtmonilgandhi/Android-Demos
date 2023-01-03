/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/monil/AndroidStudioProjects/Training Projects/Android Essential - 2/AIDLLibraryFiles/app/src/main/aidl/com/example/monil/aidllibraryfiles/IRemoteProductService.aidl
 */
package com.example.monil.aidllibraryfiles;
// Declare any non-default types here with import statements

public interface IRemoteProductService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.monil.aidllibraryfiles.IRemoteProductService
{
private static final java.lang.String DESCRIPTOR = "com.example.monil.aidllibraryfiles.IRemoteProductService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.monil.aidllibraryfiles.IRemoteProductService interface,
 * generating a proxy if needed.
 */
public static com.example.monil.aidllibraryfiles.IRemoteProductService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.monil.aidllibraryfiles.IRemoteProductService))) {
return ((com.example.monil.aidllibraryfiles.IRemoteProductService)iin);
}
return new com.example.monil.aidllibraryfiles.IRemoteProductService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_addProduct:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
float _arg2;
_arg2 = data.readFloat();
this.addProduct(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_getProduct:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.example.monil.aidllibraryfiles.Product _result = this.getProduct(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.monil.aidllibraryfiles.IRemoteProductService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void addProduct(java.lang.String name, int quantity, float cost) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeInt(quantity);
_data.writeFloat(cost);
mRemote.transact(Stub.TRANSACTION_addProduct, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public com.example.monil.aidllibraryfiles.Product getProduct(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.example.monil.aidllibraryfiles.Product _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_getProduct, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.example.monil.aidllibraryfiles.Product.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_addProduct = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getProduct = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void addProduct(java.lang.String name, int quantity, float cost) throws android.os.RemoteException;
public com.example.monil.aidllibraryfiles.Product getProduct(java.lang.String name) throws android.os.RemoteException;
}
