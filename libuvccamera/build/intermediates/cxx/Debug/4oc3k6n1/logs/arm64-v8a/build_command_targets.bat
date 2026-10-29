@echo off
"C:\\Users\\yaraj\\AppData\\Local\\Android\\Sdk\\ndk\\29.0.13599879\\ndk-build.cmd" ^
  "NDK_PROJECT_PATH=null" ^
  "APP_BUILD_SCRIPT=C:\\Users\\yaraj\\OneDrive\\Desktop\\Test\\mUSBAndroid\\libuvccamera\\src\\main\\jni\\Android.mk" ^
  "NDK_APPLICATION_MK=C:\\Users\\yaraj\\OneDrive\\Desktop\\Test\\mUSBAndroid\\libuvccamera\\src\\main\\jni\\Application.mk" ^
  "APP_ABI=arm64-v8a" ^
  "NDK_ALL_ABIS=arm64-v8a" ^
  "NDK_DEBUG=1" ^
  "APP_PLATFORM=android-21" ^
  "NDK_OUT=C:\\Users\\yaraj\\OneDrive\\Desktop\\Test\\mUSBAndroid\\libuvccamera\\build\\intermediates\\cxx\\Debug\\4oc3k6n1/obj" ^
  "NDK_LIBS_OUT=C:\\Users\\yaraj\\OneDrive\\Desktop\\Test\\mUSBAndroid\\libuvccamera\\build\\intermediates\\cxx\\Debug\\4oc3k6n1/lib" ^
  UVCCamera ^
  jpeg-turbo1500 ^
  usb100 ^
  uvc
