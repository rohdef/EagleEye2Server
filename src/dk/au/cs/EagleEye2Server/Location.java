package dk.au.cs.EagleEye2Server;

public class Location {
  // ToDo: Create field "mResults".
  private String mProvider;
  private LocationExtras mExtras;
  private double mDistance;
  private long mElapsedRealtimeNanos;
  private long mTime;
  private double mAltitude;
  private double mLongitude;
  private double mLon2;
  private double mLon1;
  private double mLatitude;
  private double mLat2;
  private double mLat1;
  private boolean mIsFromMockProvider;
  private double mInitialBearing;
  private boolean mHasSpeed;
  private boolean mHasBearing;
  private boolean mHasAltitude;
  private boolean mHasAccuracy;
  private double mAccuracy;
  private double mSpeed;
  private double mBearing;

  public String toString(){
    return "[Location] Longitude: "+mLongitude+", Latitude: "+mLatitude+", Altitude: "+mAltitude+", Accuracy: "+mAccuracy+", Speed: "+mSpeed+", Extra: "+ mExtras.toString()+".";
  }

  public String getmProvider() {
    return mProvider;
  }

  public void setmProvider(String mProvider) {
    this.mProvider = mProvider;
  }

  public double getmDistance() {
    return mDistance;
  }

  public void setmDistance(double mDistance) {
    this.mDistance = mDistance;
  }

  public long getmElapsedRealtimeNanos() {
    return mElapsedRealtimeNanos;
  }

  public void setmElapsedRealtimeNanos(long mElapsedRealtimeNanos) {
    this.mElapsedRealtimeNanos = mElapsedRealtimeNanos;
  }

  public long getmTime() {
    return mTime;
  }

  public void setmTime(long mTime) {
    this.mTime = mTime;
  }

  public double getmAltitude() {
    return mAltitude;
  }

  public void setmAltitude(double mAltitude) {
    this.mAltitude = mAltitude;
  }

  public double getmLongitude() {
    return mLongitude;
  }

  public void setmLongitude(double mLongitude) {
    this.mLongitude = mLongitude;
  }

  public double getmLon2() {
    return mLon2;
  }

  public void setmLon2(double mLon2) {
    this.mLon2 = mLon2;
  }

  public double getmLon1() {
    return mLon1;
  }

  public void setmLon1(double mLon1) {
    this.mLon1 = mLon1;
  }

  public double getmLatitude() {
    return mLatitude;
  }

  public void setmLatitude(double mLatitude) {
    this.mLatitude = mLatitude;
  }

  public double getmLat2() {
    return mLat2;
  }

  public void setmLat2(double mLat2) {
    this.mLat2 = mLat2;
  }

  public double getmLat1() {
    return mLat1;
  }

  public void setmLat1(double mLat1) {
    this.mLat1 = mLat1;
  }

  public boolean ismIsFromMockProvider() {
    return mIsFromMockProvider;
  }

  public void setmIsFromMockProvider(boolean mIsFromMockProvider) {
    this.mIsFromMockProvider = mIsFromMockProvider;
  }

  public double getmInitialBearing() {
    return mInitialBearing;
  }

  public void setmInitialBearing(double mInitialBearing) {
    this.mInitialBearing = mInitialBearing;
  }

  public boolean ismHasSpeed() {
    return mHasSpeed;
  }

  public void setmHasSpeed(boolean mHasSpeed) {
    this.mHasSpeed = mHasSpeed;
  }

  public boolean ismHasBearing() {
    return mHasBearing;
  }

  public void setmHasBearing(boolean mHasBearing) {
    this.mHasBearing = mHasBearing;
  }

  public boolean ismHasAltitude() {
    return mHasAltitude;
  }

  public void setmHasAltitude(boolean mHasAltitude) {
    this.mHasAltitude = mHasAltitude;
  }

  public boolean ismHasAccuracy() {
    return mHasAccuracy;
  }

  public void setmHasAccuracy(boolean mHasAccuracy) {
    this.mHasAccuracy = mHasAccuracy;
  }

  public double getmAccuracy() {
    return mAccuracy;
  }

  public void setmAccuracy(double mAccuracy) {
    this.mAccuracy = mAccuracy;
  }

  public double getmSpeed() {
    return mSpeed;
  }

  public void setmSpeed(double mSpeed) {
    this.mSpeed = mSpeed;
  }

  public LocationExtras getmExtras() {
    return mExtras;
  }

  public void setmExtras(LocationExtras mExtras) {
    this.mExtras = mExtras;
  }
}
