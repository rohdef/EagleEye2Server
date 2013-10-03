package dk.au.cs.EagleEye2Server;

public class LocationExtras {
  private LocationParcelledData mParcelledData;
  private boolean mHasFds;
  private boolean mFdsKnown;
  private boolean mAllowFds;

  public String toString(){
    return "[Extra] ParcelledData: "+mParcelledData.toString();
  }

  public boolean ismHasFds() {
    return mHasFds;
  }

  public void setmHasFds(boolean mHasFds) {
    this.mHasFds = mHasFds;
  }

  public boolean ismFdsKnown() {
    return mFdsKnown;
  }

  public void setmFdsKnown(boolean mFdsKnown) {
    this.mFdsKnown = mFdsKnown;
  }

  public boolean ismAllowFds() {
    return mAllowFds;
  }

  public void setmAllowFds(boolean mAllowFds) {
    this.mAllowFds = mAllowFds;
  }

  public LocationParcelledData getmParcelledData() {
    return mParcelledData;
  }

  public void setmParcelledData(LocationParcelledData mParcelledData) {
    this.mParcelledData = mParcelledData;
  }
}
