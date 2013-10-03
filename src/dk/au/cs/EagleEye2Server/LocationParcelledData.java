package dk.au.cs.EagleEye2Server;

public class LocationParcelledData {
  private boolean mOwnsNativeParcelObject;
  private long mNativePtr;

  public String toString(){
    return "[ParcelledData]";
  }

  public boolean ismOwnsNativeParcelObject() {
    return mOwnsNativeParcelObject;
  }

  public void setmOwnsNativeParcelObject(boolean mOwnsNativeParcelObject) {
    this.mOwnsNativeParcelObject = mOwnsNativeParcelObject;
  }

  public long getmNativePtr() {
    return mNativePtr;
  }

  public void setmNativePtr(long mNativePtr) {
    this.mNativePtr = mNativePtr;
  }
}
