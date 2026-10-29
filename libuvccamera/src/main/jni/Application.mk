#/*
# * UVCCamera
# * library and sample to access to UVC web camera on non-rooted Android device
# * 
# * Copyright (c) 2014-2017 saki t_saki@serenegiant.com
# * 
# * File name: Application.mk
# * 
# * Licensed under the Apache License, Version 2.0 (the "License");
# * you may not use this file except in compliance with the License.
# *  You may obtain a copy of the License at
# * 
# *     http://www.apache.org/licenses/LICENSE-2.0
# * 
# *  Unless required by applicable law or agreed to in writing, software
# *  distributed under the License is distributed on an "AS IS" BASIS,
# *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# *  See the License for the specific language governing permissions and
# *  limitations under the License.
# * 
# * All files in the folder are under this Apache License, Version 2.0.
# * Files in the jni/libjpeg, jni/libusb, jin/libuvc, jni/rapidjson folder may have a different license, see the respective files.
#*/

# This is just for mips, if you really needs MSA, un-comment and build with GCC.
# Note: Supporting GCC on NDK is already deprecated and GCC will be removed from NDK soon.
#NDK_TOOLCHAIN_VERSION := 4.9
# Architectures to build
APP_ABI := armeabi-v7a arm64-v8a x86_64

# Minimum platform
APP_PLATFORM := android-21

# Shared C++ STL (safe default)
APP_STL := c++_shared

# Use Clang (modern default)
NDK_TOOLCHAIN_VERSION := clang

# Enable position-independent code (fixes R_386_32 / -fPIC errors)
APP_CPPFLAGS += -fPIC
APP_CFLAGS += -fPIC

# Linker flags for 16KB page alignment and lld compatibility (NDK 27+)
APP_LDFLAGS += -Wl,-z,max-page-size=16384 -Wl,--no-undefined

# Optional: Stricter optimization and compatibility for modern NDK
APP_OPTIM := release



