/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.metadata.definition.protobuf.model;

public final class GooglePB {
    private GooglePB() {}

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

    public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
    }
    /**
     * Protobuf enum {@code org.apache.dubbo.metadata.definition.protobuf.model.PhoneType}
     */
    public enum PhoneType implements com.google.protobuf.ProtocolMessageEnum {
        /**
         * <code>MOBILE = 0;</code>
         */
        MOBILE(0),
        /**
         * <code>HOME = 1;</code>
         */
        HOME(1),
        /**
         * <code>WORK = 2;</code>
         */
        WORK(2),
        ;

        /**
         * <code>MOBILE = 0;</code>
         */
        public static final int MOBILE_VALUE = 0;
        /**
         * <code>HOME = 1;</code>
         */
        public static final int HOME_VALUE = 1;
        /**
         * <code>WORK = 2;</code>
         */
        public static final int WORK_VALUE = 2;

        public final int getNumber() {
            return value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @java.lang.Deprecated
        public static PhoneType valueOf(int value) {
            return forNumber(value);
        }

        public static PhoneType forNumber(int value) {
            switch (value) {
                case 0:
                    return MOBILE;
                case 1:
                    return HOME;
                case 2:
                    return WORK;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<PhoneType> internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<PhoneType> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<PhoneType>() {
                    public PhoneType findValueByNumber(int number) {
                        return PhoneType.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.getDescriptor()
                    .getEnumTypes()
                    .get(0);
        }

        private static final PhoneType[] VALUES = values();

        public static PhoneType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private PhoneType(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:org.apache.dubbo.metadata.definition.protobuf.model.PhoneType)
    }

    public interface PBRequestTypeOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional double money = 1;</code>
         */
        boolean hasMoney();
        /**
         * <code>optional double money = 1;</code>
         */
        double getMoney();

        /**
         * <code>optional float cash = 2;</code>
         */
        boolean hasCash();
        /**
         * <code>optional float cash = 2;</code>
         */
        float getCash();

        /**
         * <code>optional int32 age = 3;</code>
         */
        boolean hasAge();
        /**
         * <code>optional int32 age = 3;</code>
         */
        int getAge();

        /**
         * <code>optional int64 num = 4;</code>
         */
        boolean hasNum();
        /**
         * <code>optional int64 num = 4;</code>
         */
        long getNum();

        /**
         * <code>optional bool sex = 5;</code>
         */
        boolean hasSex();
        /**
         * <code>optional bool sex = 5;</code>
         */
        boolean getSex();

        /**
         * <code>optional string name = 6;</code>
         */
        boolean hasName();
        /**
         * <code>optional string name = 6;</code>
         */
        java.lang.String getName();
        /**
         * <code>optional string name = 6;</code>
         */
        com.google.protobuf.ByteString getNameBytes();

        /**
         * <code>optional bytes msg = 7;</code>
         */
        boolean hasMsg();
        /**
         * <code>optional bytes msg = 7;</code>
         */
        com.google.protobuf.ByteString getMsg();

        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber> getPhoneList();
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getPhone(int index);
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        int getPhoneCount();
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        java.util.List<? extends org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder>
                getPhoneOrBuilderList();
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder getPhoneOrBuilder(int index);

        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        int getDoubleMapCount();
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        boolean containsDoubleMap(java.lang.String key);
        /**
         * Use {@link #getDoubleMapMap()} instead.
         */
        @java.lang.Deprecated
        java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                getDoubleMap();
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                getDoubleMapMap();
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrDefault(
                java.lang.String key,
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber defaultValue);
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrThrow(
                java.lang.String key);

        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        java.util.List<com.google.protobuf.ByteString> getBytesListList();
        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        int getBytesListCount();
        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        com.google.protobuf.ByteString getBytesList(int index);

        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        int getBytesMapCount();
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        boolean containsBytesMap(java.lang.String key);
        /**
         * Use {@link #getBytesMapMap()} instead.
         */
        @java.lang.Deprecated
        java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMap();
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMapMap();
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        com.google.protobuf.ByteString getBytesMapOrDefault(
                java.lang.String key, com.google.protobuf.ByteString defaultValue);
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        com.google.protobuf.ByteString getBytesMapOrThrow(java.lang.String key);
    }
    /**
     * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType}
     */
    public static final class PBRequestType extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType)
            PBRequestTypeOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use PBRequestType.newBuilder() to construct.
        private PBRequestType(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private PBRequestType() {
            money_ = 0D;
            cash_ = 0F;
            age_ = 0;
            num_ = 0L;
            sex_ = false;
            name_ = "";
            msg_ = com.google.protobuf.ByteString.EMPTY;
            phone_ = java.util.Collections.emptyList();
            bytesList_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PBRequestType(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 9: {
                            bitField0_ |= 0x00000001;
                            money_ = input.readDouble();
                            break;
                        }
                        case 21: {
                            bitField0_ |= 0x00000002;
                            cash_ = input.readFloat();
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000004;
                            age_ = input.readInt32();
                            break;
                        }
                        case 32: {
                            bitField0_ |= 0x00000008;
                            num_ = input.readInt64();
                            break;
                        }
                        case 40: {
                            bitField0_ |= 0x00000010;
                            sex_ = input.readBool();
                            break;
                        }
                        case 50: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000020;
                            name_ = bs;
                            break;
                        }
                        case 58: {
                            bitField0_ |= 0x00000040;
                            msg_ = input.readBytes();
                            break;
                        }
                        case 66: {
                            if (!((mutable_bitField0_ & 0x00000080) == 0x00000080)) {
                                phone_ = new java.util.ArrayList<
                                        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>();
                                mutable_bitField0_ |= 0x00000080;
                            }
                            phone_.add(input.readMessage(
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.PARSER,
                                    extensionRegistry));
                            break;
                        }
                        case 74: {
                            if (!((mutable_bitField0_ & 0x00000100) == 0x00000100)) {
                                doubleMap_ = com.google.protobuf.MapField.newMapField(
                                        DoubleMapDefaultEntryHolder.defaultEntry);
                                mutable_bitField0_ |= 0x00000100;
                            }
                            com.google.protobuf.MapEntry<String, PhoneNumber> doubleMap__ = input.readMessage(
                                    DoubleMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                            doubleMap_.getMutableMap().put(doubleMap__.getKey(), doubleMap__.getValue());
                            break;
                        }
                        case 82: {
                            if (!((mutable_bitField0_ & 0x00000200) == 0x00000200)) {
                                bytesList_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
                                mutable_bitField0_ |= 0x00000200;
                            }
                            bytesList_.add(input.readBytes());
                            break;
                        }
                        case 90: {
                            if (!((mutable_bitField0_ & 0x00000400) == 0x00000400)) {
                                bytesMap_ = com.google.protobuf.MapField.newMapField(
                                        BytesMapDefaultEntryHolder.defaultEntry);
                                mutable_bitField0_ |= 0x00000400;
                            }
                            com.google.protobuf.MapEntry<String, com.google.protobuf.ByteString> bytesMap__ =
                                    input.readMessage(
                                            BytesMapDefaultEntryHolder.defaultEntry.getParserForType(),
                                            extensionRegistry);
                            bytesMap_.getMutableMap().put(bytesMap__.getKey(), bytesMap__.getValue());
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000080) == 0x00000080)) {
                    phone_ = java.util.Collections.unmodifiableList(phone_);
                }
                if (((mutable_bitField0_ & 0x00000200) == 0x00000200)) {
                    bytesList_ = java.util.Collections.unmodifiableList(bytesList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor;
        }

        @SuppressWarnings({"rawtypes"})
        protected com.google.protobuf.MapField internalGetMapField(int number) {
            switch (number) {
                case 9:
                    return internalGetDoubleMap();
                case 11:
                    return internalGetBytesMap();
                default:
                    throw new RuntimeException("Invalid map field number: " + number);
            }
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.class,
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.Builder.class);
        }

        private int bitField0_;
        public static final int MONEY_FIELD_NUMBER = 1;
        private double money_;
        /**
         * <code>optional double money = 1;</code>
         */
        public boolean hasMoney() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional double money = 1;</code>
         */
        public double getMoney() {
            return money_;
        }

        public static final int CASH_FIELD_NUMBER = 2;
        private float cash_;
        /**
         * <code>optional float cash = 2;</code>
         */
        public boolean hasCash() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional float cash = 2;</code>
         */
        public float getCash() {
            return cash_;
        }

        public static final int AGE_FIELD_NUMBER = 3;
        private int age_;
        /**
         * <code>optional int32 age = 3;</code>
         */
        public boolean hasAge() {
            return ((bitField0_ & 0x00000004) == 0x00000004);
        }
        /**
         * <code>optional int32 age = 3;</code>
         */
        public int getAge() {
            return age_;
        }

        public static final int NUM_FIELD_NUMBER = 4;
        private long num_;
        /**
         * <code>optional int64 num = 4;</code>
         */
        public boolean hasNum() {
            return ((bitField0_ & 0x00000008) == 0x00000008);
        }
        /**
         * <code>optional int64 num = 4;</code>
         */
        public long getNum() {
            return num_;
        }

        public static final int SEX_FIELD_NUMBER = 5;
        private boolean sex_;
        /**
         * <code>optional bool sex = 5;</code>
         */
        public boolean hasSex() {
            return ((bitField0_ & 0x00000010) == 0x00000010);
        }
        /**
         * <code>optional bool sex = 5;</code>
         */
        public boolean getSex() {
            return sex_;
        }

        public static final int NAME_FIELD_NUMBER = 6;
        private volatile java.lang.Object name_;
        /**
         * <code>optional string name = 6;</code>
         */
        public boolean hasName() {
            return ((bitField0_ & 0x00000020) == 0x00000020);
        }
        /**
         * <code>optional string name = 6;</code>
         */
        public java.lang.String getName() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string name = 6;</code>
         */
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int MSG_FIELD_NUMBER = 7;
        private com.google.protobuf.ByteString msg_;
        /**
         * <code>optional bytes msg = 7;</code>
         */
        public boolean hasMsg() {
            return ((bitField0_ & 0x00000040) == 0x00000040);
        }
        /**
         * <code>optional bytes msg = 7;</code>
         */
        public com.google.protobuf.ByteString getMsg() {
            return msg_;
        }

        public static final int PHONE_FIELD_NUMBER = 8;
        private java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber> phone_;
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        public java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber> getPhoneList() {
            return phone_;
        }
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        public java.util.List<
                        ? extends org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder>
                getPhoneOrBuilderList() {
            return phone_;
        }
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        public int getPhoneCount() {
            return phone_.size();
        }
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getPhone(int index) {
            return phone_.get(index);
        }
        /**
         * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder getPhoneOrBuilder(
                int index) {
            return phone_.get(index);
        }

        public static final int DOUBLEMAP_FIELD_NUMBER = 9;

        private static final class DoubleMapDefaultEntryHolder {
            static final com.google.protobuf.MapEntry<String, PhoneNumber> defaultEntry = com.google.protobuf.MapEntry
                    .<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                            newDefaultInstance(
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                                            .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_descriptor,
                                    com.google.protobuf.WireFormat.FieldType.STRING,
                                    "",
                                    com.google.protobuf.WireFormat.FieldType.MESSAGE,
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber
                                            .getDefaultInstance());
        }

        private com.google.protobuf.MapField<String, PhoneNumber> doubleMap_;

        private com.google.protobuf.MapField<String, PhoneNumber> internalGetDoubleMap() {
            if (doubleMap_ == null) {
                return com.google.protobuf.MapField.emptyMapField(DoubleMapDefaultEntryHolder.defaultEntry);
            }
            return doubleMap_;
        }

        public int getDoubleMapCount() {
            return internalGetDoubleMap().getMap().size();
        }
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        public boolean containsDoubleMap(java.lang.String key) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            return internalGetDoubleMap().getMap().containsKey(key);
        }
        /**
         * Use {@link #getDoubleMapMap()} instead.
         */
        @java.lang.Deprecated
        public java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                getDoubleMap() {
            return getDoubleMapMap();
        }
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        public java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                getDoubleMapMap() {
            return internalGetDoubleMap().getMap();
        }
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrDefault(
                java.lang.String key,
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber defaultValue) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    map = internalGetDoubleMap().getMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        /**
         * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrThrow(
                java.lang.String key) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    map = internalGetDoubleMap().getMap();
            if (!map.containsKey(key)) {
                throw new java.lang.IllegalArgumentException();
            }
            return map.get(key);
        }

        public static final int BYTESLIST_FIELD_NUMBER = 10;
        private java.util.List<com.google.protobuf.ByteString> bytesList_;
        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        public java.util.List<com.google.protobuf.ByteString> getBytesListList() {
            return bytesList_;
        }
        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        public int getBytesListCount() {
            return bytesList_.size();
        }
        /**
         * <code>repeated bytes bytesList = 10;</code>
         */
        public com.google.protobuf.ByteString getBytesList(int index) {
            return bytesList_.get(index);
        }

        public static final int BYTESMAP_FIELD_NUMBER = 11;

        private static final class BytesMapDefaultEntryHolder {
            static final com.google.protobuf.MapEntry<String, com.google.protobuf.ByteString> defaultEntry =
                    com.google.protobuf.MapEntry.<java.lang.String, com.google.protobuf.ByteString>newDefaultInstance(
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_descriptor,
                            com.google.protobuf.WireFormat.FieldType.STRING,
                            "",
                            com.google.protobuf.WireFormat.FieldType.BYTES,
                            com.google.protobuf.ByteString.EMPTY);
        }

        private com.google.protobuf.MapField<String, com.google.protobuf.ByteString> bytesMap_;

        private com.google.protobuf.MapField<String, com.google.protobuf.ByteString> internalGetBytesMap() {
            if (bytesMap_ == null) {
                return com.google.protobuf.MapField.emptyMapField(BytesMapDefaultEntryHolder.defaultEntry);
            }
            return bytesMap_;
        }

        public int getBytesMapCount() {
            return internalGetBytesMap().getMap().size();
        }
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        public boolean containsBytesMap(java.lang.String key) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            return internalGetBytesMap().getMap().containsKey(key);
        }
        /**
         * Use {@link #getBytesMapMap()} instead.
         */
        @java.lang.Deprecated
        public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMap() {
            return getBytesMapMap();
        }
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMapMap() {
            return internalGetBytesMap().getMap();
        }
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        public com.google.protobuf.ByteString getBytesMapOrDefault(
                java.lang.String key, com.google.protobuf.ByteString defaultValue) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
                    internalGetBytesMap().getMap();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }
        /**
         * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
         */
        public com.google.protobuf.ByteString getBytesMapOrThrow(java.lang.String key) {
            if (key == null) {
                throw new java.lang.NullPointerException();
            }
            java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
                    internalGetBytesMap().getMap();
            if (!map.containsKey(key)) {
                throw new java.lang.IllegalArgumentException();
            }
            return map.get(key);
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            for (int i = 0; i < getPhoneCount(); i++) {
                if (!getPhone(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber item :
                    getDoubleMapMap().values()) {
                if (!item.isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                output.writeDouble(1, money_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeFloat(2, cash_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                output.writeInt32(3, age_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                output.writeInt64(4, num_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                output.writeBool(5, sex_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 6, name_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                output.writeBytes(7, msg_);
            }
            for (int i = 0; i < phone_.size(); i++) {
                output.writeMessage(8, phone_.get(i));
            }
            com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(
                    output, internalGetDoubleMap(), DoubleMapDefaultEntryHolder.defaultEntry, 9);
            for (int i = 0; i < bytesList_.size(); i++) {
                output.writeBytes(10, bytesList_.get(i));
            }
            com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(
                    output, internalGetBytesMap(), BytesMapDefaultEntryHolder.defaultEntry, 11);
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.CodedOutputStream.computeDoubleSize(1, money_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeFloatSize(2, cash_);
            }
            if (((bitField0_ & 0x00000004) == 0x00000004)) {
                size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, age_);
            }
            if (((bitField0_ & 0x00000008) == 0x00000008)) {
                size += com.google.protobuf.CodedOutputStream.computeInt64Size(4, num_);
            }
            if (((bitField0_ & 0x00000010) == 0x00000010)) {
                size += com.google.protobuf.CodedOutputStream.computeBoolSize(5, sex_);
            }
            if (((bitField0_ & 0x00000020) == 0x00000020)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, name_);
            }
            if (((bitField0_ & 0x00000040) == 0x00000040)) {
                size += com.google.protobuf.CodedOutputStream.computeBytesSize(7, msg_);
            }
            for (int i = 0; i < phone_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(8, phone_.get(i));
            }
            for (java.util.Map.Entry<
                            java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    entry : internalGetDoubleMap().getMap().entrySet()) {
                com.google.protobuf.MapEntry<String, PhoneNumber> doubleMap__ = DoubleMapDefaultEntryHolder.defaultEntry
                        .newBuilderForType()
                        .setKey(entry.getKey())
                        .setValue(entry.getValue())
                        .build();
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(9, doubleMap__);
            }
            {
                int dataSize = 0;
                for (int i = 0; i < bytesList_.size(); i++) {
                    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag(bytesList_.get(i));
                }
                size += dataSize;
                size += 1 * getBytesListList().size();
            }
            for (java.util.Map.Entry<java.lang.String, com.google.protobuf.ByteString> entry :
                    internalGetBytesMap().getMap().entrySet()) {
                com.google.protobuf.MapEntry<String, com.google.protobuf.ByteString> bytesMap__ =
                        BytesMapDefaultEntryHolder.defaultEntry
                                .newBuilderForType()
                                .setKey(entry.getKey())
                                .setValue(entry.getValue())
                                .build();
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(11, bytesMap__);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType)) {
                return super.equals(obj);
            }
            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType other =
                    (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType) obj;

            boolean result = true;
            result = result && (hasMoney() == other.hasMoney());
            if (hasMoney()) {
                result = result
                        && (java.lang.Double.doubleToLongBits(getMoney())
                                == java.lang.Double.doubleToLongBits(other.getMoney()));
            }
            result = result && (hasCash() == other.hasCash());
            if (hasCash()) {
                result = result
                        && (java.lang.Float.floatToIntBits(getCash())
                                == java.lang.Float.floatToIntBits(other.getCash()));
            }
            result = result && (hasAge() == other.hasAge());
            if (hasAge()) {
                result = result && (getAge() == other.getAge());
            }
            result = result && (hasNum() == other.hasNum());
            if (hasNum()) {
                result = result && (getNum() == other.getNum());
            }
            result = result && (hasSex() == other.hasSex());
            if (hasSex()) {
                result = result && (getSex() == other.getSex());
            }
            result = result && (hasName() == other.hasName());
            if (hasName()) {
                result = result && getName().equals(other.getName());
            }
            result = result && (hasMsg() == other.hasMsg());
            if (hasMsg()) {
                result = result && getMsg().equals(other.getMsg());
            }
            result = result && getPhoneList().equals(other.getPhoneList());
            result = result && internalGetDoubleMap().equals(other.internalGetDoubleMap());
            result = result && getBytesListList().equals(other.getBytesListList());
            result = result && internalGetBytesMap().equals(other.internalGetBytesMap());
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasMoney()) {
                hash = (37 * hash) + MONEY_FIELD_NUMBER;
                hash = (53 * hash)
                        + com.google.protobuf.Internal.hashLong(java.lang.Double.doubleToLongBits(getMoney()));
            }
            if (hasCash()) {
                hash = (37 * hash) + CASH_FIELD_NUMBER;
                hash = (53 * hash) + java.lang.Float.floatToIntBits(getCash());
            }
            if (hasAge()) {
                hash = (37 * hash) + AGE_FIELD_NUMBER;
                hash = (53 * hash) + getAge();
            }
            if (hasNum()) {
                hash = (37 * hash) + NUM_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getNum());
            }
            if (hasSex()) {
                hash = (37 * hash) + SEX_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getSex());
            }
            if (hasName()) {
                hash = (37 * hash) + NAME_FIELD_NUMBER;
                hash = (53 * hash) + getName().hashCode();
            }
            if (hasMsg()) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsg().hashCode();
            }
            if (getPhoneCount() > 0) {
                hash = (37 * hash) + PHONE_FIELD_NUMBER;
                hash = (53 * hash) + getPhoneList().hashCode();
            }
            if (!internalGetDoubleMap().getMap().isEmpty()) {
                hash = (37 * hash) + DOUBLEMAP_FIELD_NUMBER;
                hash = (53 * hash) + internalGetDoubleMap().hashCode();
            }
            if (getBytesListCount() > 0) {
                hash = (37 * hash) + BYTESLIST_FIELD_NUMBER;
                hash = (53 * hash) + getBytesListList().hashCode();
            }
            if (!internalGetBytesMap().getMap().isEmpty()) {
                hash = (37 * hash) + BYTESMAP_FIELD_NUMBER;
                hash = (53 * hash) + internalGetBytesMap().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseDelimitedFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseDelimitedFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parseFrom(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType)
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestTypeOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor;
            }

            @SuppressWarnings({"rawtypes"})
            protected com.google.protobuf.MapField internalGetMapField(int number) {
                switch (number) {
                    case 9:
                        return internalGetDoubleMap();
                    case 11:
                        return internalGetBytesMap();
                    default:
                        throw new RuntimeException("Invalid map field number: " + number);
                }
            }

            @SuppressWarnings({"rawtypes"})
            protected com.google.protobuf.MapField internalGetMutableMapField(int number) {
                switch (number) {
                    case 9:
                        return internalGetMutableDoubleMap();
                    case 11:
                        return internalGetMutableBytesMap();
                    default:
                        throw new RuntimeException("Invalid map field number: " + number);
                }
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.class,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.Builder
                                        .class);
            }

            // Construct using org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getPhoneFieldBuilder();
                }
            }

            public Builder clear() {
                super.clear();
                money_ = 0D;
                bitField0_ = (bitField0_ & ~0x00000001);
                cash_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000002);
                age_ = 0;
                bitField0_ = (bitField0_ & ~0x00000004);
                num_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000008);
                sex_ = false;
                bitField0_ = (bitField0_ & ~0x00000010);
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000020);
                msg_ = com.google.protobuf.ByteString.EMPTY;
                bitField0_ = (bitField0_ & ~0x00000040);
                if (phoneBuilder_ == null) {
                    phone_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000080);
                } else {
                    phoneBuilder_.clear();
                }
                internalGetMutableDoubleMap().clear();
                bytesList_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000200);
                internalGetMutableBytesMap().clear();
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                    getDefaultInstanceForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.getDefaultInstance();
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType build() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType buildPartial() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType result =
                        new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.money_ = money_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.cash_ = cash_;
                if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.age_ = age_;
                if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.num_ = num_;
                if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.sex_ = sex_;
                if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
                    to_bitField0_ |= 0x00000040;
                }
                result.msg_ = msg_;
                if (phoneBuilder_ == null) {
                    if (((bitField0_ & 0x00000080) == 0x00000080)) {
                        phone_ = java.util.Collections.unmodifiableList(phone_);
                        bitField0_ = (bitField0_ & ~0x00000080);
                    }
                    result.phone_ = phone_;
                } else {
                    result.phone_ = phoneBuilder_.build();
                }
                result.doubleMap_ = internalGetDoubleMap();
                result.doubleMap_.makeImmutable();
                if (((bitField0_ & 0x00000200) == 0x00000200)) {
                    bytesList_ = java.util.Collections.unmodifiableList(bytesList_);
                    bitField0_ = (bitField0_ & ~0x00000200);
                }
                result.bytesList_ = bytesList_;
                result.bytesMap_ = internalGetBytesMap();
                result.bytesMap_.makeImmutable();
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType) {
                    return mergeFrom(
                            (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType other) {
                if (other
                        == org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                                .getDefaultInstance()) return this;
                if (other.hasMoney()) {
                    setMoney(other.getMoney());
                }
                if (other.hasCash()) {
                    setCash(other.getCash());
                }
                if (other.hasAge()) {
                    setAge(other.getAge());
                }
                if (other.hasNum()) {
                    setNum(other.getNum());
                }
                if (other.hasSex()) {
                    setSex(other.getSex());
                }
                if (other.hasName()) {
                    bitField0_ |= 0x00000020;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasMsg()) {
                    setMsg(other.getMsg());
                }
                if (phoneBuilder_ == null) {
                    if (!other.phone_.isEmpty()) {
                        if (phone_.isEmpty()) {
                            phone_ = other.phone_;
                            bitField0_ = (bitField0_ & ~0x00000080);
                        } else {
                            ensurePhoneIsMutable();
                            phone_.addAll(other.phone_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.phone_.isEmpty()) {
                        if (phoneBuilder_.isEmpty()) {
                            phoneBuilder_.dispose();
                            phoneBuilder_ = null;
                            phone_ = other.phone_;
                            bitField0_ = (bitField0_ & ~0x00000080);
                            phoneBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                                    ? getPhoneFieldBuilder()
                                    : null;
                        } else {
                            phoneBuilder_.addAllMessages(other.phone_);
                        }
                    }
                }
                internalGetMutableDoubleMap().mergeFrom(other.internalGetDoubleMap());
                if (!other.bytesList_.isEmpty()) {
                    if (bytesList_.isEmpty()) {
                        bytesList_ = other.bytesList_;
                        bitField0_ = (bitField0_ & ~0x00000200);
                    } else {
                        ensureBytesListIsMutable();
                        bytesList_.addAll(other.bytesList_);
                    }
                    onChanged();
                }
                internalGetMutableBytesMap().mergeFrom(other.internalGetBytesMap());
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getPhoneCount(); i++) {
                    if (!getPhone(i).isInitialized()) {
                        return false;
                    }
                }
                for (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber item :
                        getDoubleMapMap().values()) {
                    if (!item.isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType)
                            e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private double money_;
            /**
             * <code>optional double money = 1;</code>
             */
            public boolean hasMoney() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional double money = 1;</code>
             */
            public double getMoney() {
                return money_;
            }
            /**
             * <code>optional double money = 1;</code>
             */
            public Builder setMoney(double value) {
                bitField0_ |= 0x00000001;
                money_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional double money = 1;</code>
             */
            public Builder clearMoney() {
                bitField0_ = (bitField0_ & ~0x00000001);
                money_ = 0D;
                onChanged();
                return this;
            }

            private float cash_;
            /**
             * <code>optional float cash = 2;</code>
             */
            public boolean hasCash() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional float cash = 2;</code>
             */
            public float getCash() {
                return cash_;
            }
            /**
             * <code>optional float cash = 2;</code>
             */
            public Builder setCash(float value) {
                bitField0_ |= 0x00000002;
                cash_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional float cash = 2;</code>
             */
            public Builder clearCash() {
                bitField0_ = (bitField0_ & ~0x00000002);
                cash_ = 0F;
                onChanged();
                return this;
            }

            private int age_;
            /**
             * <code>optional int32 age = 3;</code>
             */
            public boolean hasAge() {
                return ((bitField0_ & 0x00000004) == 0x00000004);
            }
            /**
             * <code>optional int32 age = 3;</code>
             */
            public int getAge() {
                return age_;
            }
            /**
             * <code>optional int32 age = 3;</code>
             */
            public Builder setAge(int value) {
                bitField0_ |= 0x00000004;
                age_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional int32 age = 3;</code>
             */
            public Builder clearAge() {
                bitField0_ = (bitField0_ & ~0x00000004);
                age_ = 0;
                onChanged();
                return this;
            }

            private long num_;
            /**
             * <code>optional int64 num = 4;</code>
             */
            public boolean hasNum() {
                return ((bitField0_ & 0x00000008) == 0x00000008);
            }
            /**
             * <code>optional int64 num = 4;</code>
             */
            public long getNum() {
                return num_;
            }
            /**
             * <code>optional int64 num = 4;</code>
             */
            public Builder setNum(long value) {
                bitField0_ |= 0x00000008;
                num_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional int64 num = 4;</code>
             */
            public Builder clearNum() {
                bitField0_ = (bitField0_ & ~0x00000008);
                num_ = 0L;
                onChanged();
                return this;
            }

            private boolean sex_;
            /**
             * <code>optional bool sex = 5;</code>
             */
            public boolean hasSex() {
                return ((bitField0_ & 0x00000010) == 0x00000010);
            }
            /**
             * <code>optional bool sex = 5;</code>
             */
            public boolean getSex() {
                return sex_;
            }
            /**
             * <code>optional bool sex = 5;</code>
             */
            public Builder setSex(boolean value) {
                bitField0_ |= 0x00000010;
                sex_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional bool sex = 5;</code>
             */
            public Builder clearSex() {
                bitField0_ = (bitField0_ & ~0x00000010);
                sex_ = false;
                onChanged();
                return this;
            }

            private java.lang.Object name_ = "";
            /**
             * <code>optional string name = 6;</code>
             */
            public boolean hasName() {
                return ((bitField0_ & 0x00000020) == 0x00000020);
            }
            /**
             * <code>optional string name = 6;</code>
             */
            public java.lang.String getName() {
                java.lang.Object ref = name_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string name = 6;</code>
             */
            public com.google.protobuf.ByteString getNameBytes() {
                java.lang.Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string name = 6;</code>
             */
            public Builder setName(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                name_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string name = 6;</code>
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000020);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }
            /**
             * <code>optional string name = 6;</code>
             */
            public Builder setNameBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                name_ = value;
                onChanged();
                return this;
            }

            private com.google.protobuf.ByteString msg_ = com.google.protobuf.ByteString.EMPTY;
            /**
             * <code>optional bytes msg = 7;</code>
             */
            public boolean hasMsg() {
                return ((bitField0_ & 0x00000040) == 0x00000040);
            }
            /**
             * <code>optional bytes msg = 7;</code>
             */
            public com.google.protobuf.ByteString getMsg() {
                return msg_;
            }
            /**
             * <code>optional bytes msg = 7;</code>
             */
            public Builder setMsg(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000040;
                msg_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional bytes msg = 7;</code>
             */
            public Builder clearMsg() {
                bitField0_ = (bitField0_ & ~0x00000040);
                msg_ = getDefaultInstance().getMsg();
                onChanged();
                return this;
            }

            private java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber> phone_ =
                    java.util.Collections.emptyList();

            private void ensurePhoneIsMutable() {
                if (!((bitField0_ & 0x00000080) == 0x00000080)) {
                    phone_ = new java.util.ArrayList<
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>(phone_);
                    bitField0_ |= 0x00000080;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<PhoneNumber, PhoneNumber.Builder, PhoneNumberOrBuilder>
                    phoneBuilder_;

            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    getPhoneList() {
                if (phoneBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(phone_);
                } else {
                    return phoneBuilder_.getMessageList();
                }
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public int getPhoneCount() {
                if (phoneBuilder_ == null) {
                    return phone_.size();
                } else {
                    return phoneBuilder_.getCount();
                }
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getPhone(int index) {
                if (phoneBuilder_ == null) {
                    return phone_.get(index);
                } else {
                    return phoneBuilder_.getMessage(index);
                }
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder setPhone(
                    int index, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber value) {
                if (phoneBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePhoneIsMutable();
                    phone_.set(index, value);
                    onChanged();
                } else {
                    phoneBuilder_.setMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder setPhone(
                    int index,
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder builderForValue) {
                if (phoneBuilder_ == null) {
                    ensurePhoneIsMutable();
                    phone_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    phoneBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder addPhone(org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber value) {
                if (phoneBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePhoneIsMutable();
                    phone_.add(value);
                    onChanged();
                } else {
                    phoneBuilder_.addMessage(value);
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder addPhone(
                    int index, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber value) {
                if (phoneBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePhoneIsMutable();
                    phone_.add(index, value);
                    onChanged();
                } else {
                    phoneBuilder_.addMessage(index, value);
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder addPhone(
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder builderForValue) {
                if (phoneBuilder_ == null) {
                    ensurePhoneIsMutable();
                    phone_.add(builderForValue.build());
                    onChanged();
                } else {
                    phoneBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder addPhone(
                    int index,
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder builderForValue) {
                if (phoneBuilder_ == null) {
                    ensurePhoneIsMutable();
                    phone_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    phoneBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder addAllPhone(
                    java.lang.Iterable<
                                    ? extends org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                            values) {
                if (phoneBuilder_ == null) {
                    ensurePhoneIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(values, phone_);
                    onChanged();
                } else {
                    phoneBuilder_.addAllMessages(values);
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder clearPhone() {
                if (phoneBuilder_ == null) {
                    phone_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000080);
                    onChanged();
                } else {
                    phoneBuilder_.clear();
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public Builder removePhone(int index) {
                if (phoneBuilder_ == null) {
                    ensurePhoneIsMutable();
                    phone_.remove(index);
                    onChanged();
                } else {
                    phoneBuilder_.remove(index);
                }
                return this;
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder getPhoneBuilder(
                    int index) {
                return getPhoneFieldBuilder().getBuilder(index);
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder getPhoneOrBuilder(
                    int index) {
                if (phoneBuilder_ == null) {
                    return phone_.get(index);
                } else {
                    return phoneBuilder_.getMessageOrBuilder(index);
                }
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public java.util.List<
                            ? extends org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder>
                    getPhoneOrBuilderList() {
                if (phoneBuilder_ != null) {
                    return phoneBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(phone_);
                }
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder addPhoneBuilder() {
                return getPhoneFieldBuilder()
                        .addBuilder(
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber
                                        .getDefaultInstance());
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder addPhoneBuilder(
                    int index) {
                return getPhoneFieldBuilder()
                        .addBuilder(
                                index,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber
                                        .getDefaultInstance());
            }
            /**
             * <code>repeated .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber phone = 8;</code>
             */
            public java.util.List<org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder>
                    getPhoneBuilderList() {
                return getPhoneFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<PhoneNumber, PhoneNumber.Builder, PhoneNumberOrBuilder>
                    getPhoneFieldBuilder() {
                if (phoneBuilder_ == null) {
                    phoneBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            PhoneNumber, PhoneNumber.Builder, PhoneNumberOrBuilder>(
                            phone_, ((bitField0_ & 0x00000080) == 0x00000080), getParentForChildren(), isClean());
                    phone_ = null;
                }
                return phoneBuilder_;
            }

            private com.google.protobuf.MapField<String, PhoneNumber> doubleMap_;

            private com.google.protobuf.MapField<String, PhoneNumber> internalGetDoubleMap() {
                if (doubleMap_ == null) {
                    return com.google.protobuf.MapField.emptyMapField(DoubleMapDefaultEntryHolder.defaultEntry);
                }
                return doubleMap_;
            }

            private com.google.protobuf.MapField<String, PhoneNumber> internalGetMutableDoubleMap() {
                onChanged();
                ;
                if (doubleMap_ == null) {
                    doubleMap_ = com.google.protobuf.MapField.newMapField(DoubleMapDefaultEntryHolder.defaultEntry);
                }
                if (!doubleMap_.isMutable()) {
                    doubleMap_ = doubleMap_.copy();
                }
                return doubleMap_;
            }

            public int getDoubleMapCount() {
                return internalGetDoubleMap().getMap().size();
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public boolean containsDoubleMap(java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                return internalGetDoubleMap().getMap().containsKey(key);
            }
            /**
             * Use {@link #getDoubleMapMap()} instead.
             */
            @java.lang.Deprecated
            public java.util.Map<
                            java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    getDoubleMap() {
                return getDoubleMapMap();
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public java.util.Map<
                            java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    getDoubleMapMap() {
                return internalGetDoubleMap().getMap();
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrDefault(
                    java.lang.String key,
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber defaultValue) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                java.util.Map<
                                java.lang.String,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                        map = internalGetDoubleMap().getMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDoubleMapOrThrow(
                    java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                java.util.Map<
                                java.lang.String,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                        map = internalGetDoubleMap().getMap();
                if (!map.containsKey(key)) {
                    throw new java.lang.IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder clearDoubleMap() {
                internalGetMutableDoubleMap().getMutableMap().clear();
                return this;
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public Builder removeDoubleMap(java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                internalGetMutableDoubleMap().getMutableMap().remove(key);
                return this;
            }
            /**
             * Use alternate mutation accessors instead.
             */
            @java.lang.Deprecated
            public java.util.Map<
                            java.lang.String, org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                    getMutableDoubleMap() {
                return internalGetMutableDoubleMap().getMutableMap();
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public Builder putDoubleMap(
                    java.lang.String key,
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber value) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                if (value == null) {
                    throw new java.lang.NullPointerException();
                }
                internalGetMutableDoubleMap().getMutableMap().put(key, value);
                return this;
            }
            /**
             * <code>map&lt;string, .org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber&gt; doubleMap = 9;</code>
             */
            public Builder putAllDoubleMap(
                    java.util.Map<
                                    java.lang.String,
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber>
                            values) {
                internalGetMutableDoubleMap().getMutableMap().putAll(values);
                return this;
            }

            private java.util.List<com.google.protobuf.ByteString> bytesList_ = java.util.Collections.emptyList();

            private void ensureBytesListIsMutable() {
                if (!((bitField0_ & 0x00000200) == 0x00000200)) {
                    bytesList_ = new java.util.ArrayList<com.google.protobuf.ByteString>(bytesList_);
                    bitField0_ |= 0x00000200;
                }
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public java.util.List<com.google.protobuf.ByteString> getBytesListList() {
                return java.util.Collections.unmodifiableList(bytesList_);
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public int getBytesListCount() {
                return bytesList_.size();
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public com.google.protobuf.ByteString getBytesList(int index) {
                return bytesList_.get(index);
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public Builder setBytesList(int index, com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureBytesListIsMutable();
                bytesList_.set(index, value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public Builder addBytesList(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureBytesListIsMutable();
                bytesList_.add(value);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public Builder addAllBytesList(java.lang.Iterable<? extends com.google.protobuf.ByteString> values) {
                ensureBytesListIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(values, bytesList_);
                onChanged();
                return this;
            }
            /**
             * <code>repeated bytes bytesList = 10;</code>
             */
            public Builder clearBytesList() {
                bytesList_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000200);
                onChanged();
                return this;
            }

            private com.google.protobuf.MapField<String, com.google.protobuf.ByteString> bytesMap_;

            private com.google.protobuf.MapField<String, com.google.protobuf.ByteString> internalGetBytesMap() {
                if (bytesMap_ == null) {
                    return com.google.protobuf.MapField.emptyMapField(BytesMapDefaultEntryHolder.defaultEntry);
                }
                return bytesMap_;
            }

            private com.google.protobuf.MapField<String, com.google.protobuf.ByteString> internalGetMutableBytesMap() {
                onChanged();
                ;
                if (bytesMap_ == null) {
                    bytesMap_ = com.google.protobuf.MapField.newMapField(BytesMapDefaultEntryHolder.defaultEntry);
                }
                if (!bytesMap_.isMutable()) {
                    bytesMap_ = bytesMap_.copy();
                }
                return bytesMap_;
            }

            public int getBytesMapCount() {
                return internalGetBytesMap().getMap().size();
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public boolean containsBytesMap(java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                return internalGetBytesMap().getMap().containsKey(key);
            }
            /**
             * Use {@link #getBytesMapMap()} instead.
             */
            @java.lang.Deprecated
            public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMap() {
                return getBytesMapMap();
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getBytesMapMap() {
                return internalGetBytesMap().getMap();
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public com.google.protobuf.ByteString getBytesMapOrDefault(
                    java.lang.String key, com.google.protobuf.ByteString defaultValue) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
                        internalGetBytesMap().getMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public com.google.protobuf.ByteString getBytesMapOrThrow(java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                java.util.Map<java.lang.String, com.google.protobuf.ByteString> map =
                        internalGetBytesMap().getMap();
                if (!map.containsKey(key)) {
                    throw new java.lang.IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder clearBytesMap() {
                internalGetMutableBytesMap().getMutableMap().clear();
                return this;
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public Builder removeBytesMap(java.lang.String key) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                internalGetMutableBytesMap().getMutableMap().remove(key);
                return this;
            }
            /**
             * Use alternate mutation accessors instead.
             */
            @java.lang.Deprecated
            public java.util.Map<java.lang.String, com.google.protobuf.ByteString> getMutableBytesMap() {
                return internalGetMutableBytesMap().getMutableMap();
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public Builder putBytesMap(java.lang.String key, com.google.protobuf.ByteString value) {
                if (key == null) {
                    throw new java.lang.NullPointerException();
                }
                if (value == null) {
                    throw new java.lang.NullPointerException();
                }
                internalGetMutableBytesMap().getMutableMap().put(key, value);
                return this;
            }
            /**
             * <code>map&lt;string, bytes&gt; bytesMap = 11;</code>
             */
            public Builder putAllBytesMap(java.util.Map<java.lang.String, com.google.protobuf.ByteString> values) {
                internalGetMutableBytesMap().getMutableMap().putAll(values);
                return this;
            }

            public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType)
        }

        // @@protoc_insertion_point(class_scope:org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType)
        private static final org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType();
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<PBRequestType> PARSER =
                new com.google.protobuf.AbstractParser<PBRequestType>() {
                    public PBRequestType parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new PBRequestType(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<PBRequestType> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<PBRequestType> getParserForType() {
            return PARSER;
        }

        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface PBResponseTypeOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string msg = 1;</code>
         */
        boolean hasMsg();
        /**
         * <code>optional string msg = 1;</code>
         */
        java.lang.String getMsg();
        /**
         * <code>optional string msg = 1;</code>
         */
        com.google.protobuf.ByteString getMsgBytes();

        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        boolean hasCDubboPBRequestType();
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType getCDubboPBRequestType();
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestTypeOrBuilder
                getCDubboPBRequestTypeOrBuilder();
    }
    /**
     * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType}
     */
    public static final class PBResponseType extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType)
            PBResponseTypeOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use PBResponseType.newBuilder() to construct.
        private PBResponseType(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private PBResponseType() {
            msg_ = "";
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PBResponseType(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            msg_ = bs;
                            break;
                        }
                        case 26: {
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.Builder
                                    subBuilder = null;
                            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                                subBuilder = cDubboPBRequestType_.toBuilder();
                            }
                            cDubboPBRequestType_ = input.readMessage(
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.PARSER,
                                    extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(cDubboPBRequestType_);
                                cDubboPBRequestType_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000002;
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.class,
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.Builder.class);
        }

        private int bitField0_;
        public static final int MSG_FIELD_NUMBER = 1;
        private volatile java.lang.Object msg_;
        /**
         * <code>optional string msg = 1;</code>
         */
        public boolean hasMsg() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>optional string msg = 1;</code>
         */
        public java.lang.String getMsg() {
            java.lang.Object ref = msg_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    msg_ = s;
                }
                return s;
            }
        }
        /**
         * <code>optional string msg = 1;</code>
         */
        public com.google.protobuf.ByteString getMsgBytes() {
            java.lang.Object ref = msg_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                msg_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int CDUBBOPBREQUESTTYPE_FIELD_NUMBER = 3;
        private org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType cDubboPBRequestType_;
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        public boolean hasCDubboPBRequestType() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType getCDubboPBRequestType() {
            return cDubboPBRequestType_ == null
                    ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.getDefaultInstance()
                    : cDubboPBRequestType_;
        }
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestTypeOrBuilder
                getCDubboPBRequestTypeOrBuilder() {
            return cDubboPBRequestType_ == null
                    ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.getDefaultInstance()
                    : cDubboPBRequestType_;
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (hasCDubboPBRequestType()) {
                if (!getCDubboPBRequestType().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, msg_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeMessage(3, getCDubboPBRequestType());
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, msg_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getCDubboPBRequestType());
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType)) {
                return super.equals(obj);
            }
            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType other =
                    (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType) obj;

            boolean result = true;
            result = result && (hasMsg() == other.hasMsg());
            if (hasMsg()) {
                result = result && getMsg().equals(other.getMsg());
            }
            result = result && (hasCDubboPBRequestType() == other.hasCDubboPBRequestType());
            if (hasCDubboPBRequestType()) {
                result = result && getCDubboPBRequestType().equals(other.getCDubboPBRequestType());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasMsg()) {
                hash = (37 * hash) + MSG_FIELD_NUMBER;
                hash = (53 * hash) + getMsg().hashCode();
            }
            if (hasCDubboPBRequestType()) {
                hash = (37 * hash) + CDUBBOPBREQUESTTYPE_FIELD_NUMBER;
                hash = (53 * hash) + getCDubboPBRequestType().hashCode();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseDelimitedFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseDelimitedFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parseFrom(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType)
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseTypeOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.class,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.Builder
                                        .class);
            }

            // Construct using org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getCDubboPBRequestTypeFieldBuilder();
                }
            }

            public Builder clear() {
                super.clear();
                msg_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                if (cDubboPBRequestTypeBuilder_ == null) {
                    cDubboPBRequestType_ = null;
                } else {
                    cDubboPBRequestTypeBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType
                    getDefaultInstanceForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType.getDefaultInstance();
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType build() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType buildPartial() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType result =
                        new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.msg_ = msg_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                if (cDubboPBRequestTypeBuilder_ == null) {
                    result.cDubboPBRequestType_ = cDubboPBRequestType_;
                } else {
                    result.cDubboPBRequestType_ = cDubboPBRequestTypeBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType) {
                    return mergeFrom(
                            (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType other) {
                if (other
                        == org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType
                                .getDefaultInstance()) return this;
                if (other.hasMsg()) {
                    bitField0_ |= 0x00000001;
                    msg_ = other.msg_;
                    onChanged();
                }
                if (other.hasCDubboPBRequestType()) {
                    mergeCDubboPBRequestType(other.getCDubboPBRequestType());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (hasCDubboPBRequestType()) {
                    if (!getCDubboPBRequestType().isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType)
                            e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object msg_ = "";
            /**
             * <code>optional string msg = 1;</code>
             */
            public boolean hasMsg() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>optional string msg = 1;</code>
             */
            public java.lang.String getMsg() {
                java.lang.Object ref = msg_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        msg_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>optional string msg = 1;</code>
             */
            public com.google.protobuf.ByteString getMsgBytes() {
                java.lang.Object ref = msg_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                    msg_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>optional string msg = 1;</code>
             */
            public Builder setMsg(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                msg_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>optional string msg = 1;</code>
             */
            public Builder clearMsg() {
                bitField0_ = (bitField0_ & ~0x00000001);
                msg_ = getDefaultInstance().getMsg();
                onChanged();
                return this;
            }
            /**
             * <code>optional string msg = 1;</code>
             */
            public Builder setMsgBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                msg_ = value;
                onChanged();
                return this;
            }

            private org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType cDubboPBRequestType_ =
                    null;
            private com.google.protobuf.SingleFieldBuilderV3<
                            PBRequestType, PBRequestType.Builder, PBRequestTypeOrBuilder>
                    cDubboPBRequestTypeBuilder_;
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public boolean hasCDubboPBRequestType() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType getCDubboPBRequestType() {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    return cDubboPBRequestType_ == null
                            ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                                    .getDefaultInstance()
                            : cDubboPBRequestType_;
                } else {
                    return cDubboPBRequestTypeBuilder_.getMessage();
                }
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public Builder setCDubboPBRequestType(
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType value) {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    cDubboPBRequestType_ = value;
                    onChanged();
                } else {
                    cDubboPBRequestTypeBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public Builder setCDubboPBRequestType(
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.Builder
                            builderForValue) {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    cDubboPBRequestType_ = builderForValue.build();
                    onChanged();
                } else {
                    cDubboPBRequestTypeBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public Builder mergeCDubboPBRequestType(
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType value) {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) == 0x00000002)
                            && cDubboPBRequestType_ != null
                            && cDubboPBRequestType_
                                    != org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                                            .getDefaultInstance()) {
                        cDubboPBRequestType_ =
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.newBuilder(
                                                cDubboPBRequestType_)
                                        .mergeFrom(value)
                                        .buildPartial();
                    } else {
                        cDubboPBRequestType_ = value;
                    }
                    onChanged();
                } else {
                    cDubboPBRequestTypeBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public Builder clearCDubboPBRequestType() {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    cDubboPBRequestType_ = null;
                    onChanged();
                } else {
                    cDubboPBRequestTypeBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType.Builder
                    getCDubboPBRequestTypeBuilder() {
                bitField0_ |= 0x00000002;
                onChanged();
                return getCDubboPBRequestTypeFieldBuilder().getBuilder();
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestTypeOrBuilder
                    getCDubboPBRequestTypeOrBuilder() {
                if (cDubboPBRequestTypeBuilder_ != null) {
                    return cDubboPBRequestTypeBuilder_.getMessageOrBuilder();
                } else {
                    return cDubboPBRequestType_ == null
                            ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBRequestType
                                    .getDefaultInstance()
                            : cDubboPBRequestType_;
                }
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PBRequestType CDubboPBRequestType = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                            PBRequestType, PBRequestType.Builder, PBRequestTypeOrBuilder>
                    getCDubboPBRequestTypeFieldBuilder() {
                if (cDubboPBRequestTypeBuilder_ == null) {
                    cDubboPBRequestTypeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            PBRequestType, PBRequestType.Builder, PBRequestTypeOrBuilder>(
                            getCDubboPBRequestType(), getParentForChildren(), isClean());
                    cDubboPBRequestType_ = null;
                }
                return cDubboPBRequestTypeBuilder_;
            }

            public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType)
        }

        // @@protoc_insertion_point(class_scope:org.apache.dubbo.metadata.definition.protobuf.model.PBResponseType)
        private static final org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType
                DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType();
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<PBResponseType> PARSER =
                new com.google.protobuf.AbstractParser<PBResponseType>() {
                    public PBResponseType parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new PBResponseType(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<PBResponseType> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<PBResponseType> getParserForType() {
            return PARSER;
        }

        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PBResponseType getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public interface PhoneNumberOrBuilder
            extends
            // @@protoc_insertion_point(interface_extends:org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required string number = 1;</code>
         */
        boolean hasNumber();
        /**
         * <code>required string number = 1;</code>
         */
        java.lang.String getNumber();
        /**
         * <code>required string number = 1;</code>
         */
        com.google.protobuf.ByteString getNumberBytes();

        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
         */
        boolean hasType();
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
         */
        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType getType();
    }
    /**
     * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber}
     */
    public static final class PhoneNumber extends com.google.protobuf.GeneratedMessageV3
            implements
            // @@protoc_insertion_point(message_implements:org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber)
            PhoneNumberOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use PhoneNumber.newBuilder() to construct.
        private PhoneNumber(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private PhoneNumber() {
            number_ = "";
            type_ = 1;
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PhoneNumber(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default: {
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            number_ = bs;
                            break;
                        }
                        case 16: {
                            int rawValue = input.readEnum();
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType value =
                                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType.valueOf(
                                            rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                            } else {
                                bitField0_ |= 0x00000002;
                                type_ = rawValue;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor;
        }

        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                    .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.class,
                            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder.class);
        }

        private int bitField0_;
        public static final int NUMBER_FIELD_NUMBER = 1;
        private volatile java.lang.Object number_;
        /**
         * <code>required string number = 1;</code>
         */
        public boolean hasNumber() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }
        /**
         * <code>required string number = 1;</code>
         */
        public java.lang.String getNumber() {
            java.lang.Object ref = number_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    number_ = s;
                }
                return s;
            }
        }
        /**
         * <code>required string number = 1;</code>
         */
        public com.google.protobuf.ByteString getNumberBytes() {
            java.lang.Object ref = number_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                number_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int TYPE_FIELD_NUMBER = 2;
        private int type_;
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
         */
        public boolean hasType() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }
        /**
         * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
         */
        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType getType() {
            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType result =
                    org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType.valueOf(type_);
            return result == null
                    ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType.HOME
                    : result;
        }

        private byte memoizedIsInitialized = -1;

        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasNumber()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, number_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeEnum(2, type_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, number_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream.computeEnumSize(2, type_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber)) {
                return super.equals(obj);
            }
            org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber other =
                    (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber) obj;

            boolean result = true;
            result = result && (hasNumber() == other.hasNumber());
            if (hasNumber()) {
                result = result && getNumber().equals(other.getNumber());
            }
            result = result && (hasType() == other.hasType());
            if (hasType()) {
                result = result && type_ == other.type_;
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasNumber()) {
                hash = (37 * hash) + NUMBER_FIELD_NUMBER;
                hash = (53 * hash) + getNumber().hashCode();
            }
            if (hasType()) {
                hash = (37 * hash) + TYPE_FIELD_NUMBER;
                hash = (53 * hash) + type_;
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                com.google.protobuf.ByteString data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseDelimitedFrom(
                java.io.InputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseDelimitedFrom(
                java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
                    PARSER, input, extensionRegistry);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                com.google.protobuf.CodedInputStream input) throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parseFrom(
                com.google.protobuf.CodedInputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber}
         */
        public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
                implements
                // @@protoc_insertion_point(builder_implements:org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber)
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumberOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor;
            }

            protected FieldAccessorTable internalGetFieldAccessorTable() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.class,
                                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.Builder.class);
            }

            // Construct using org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
            }

            public Builder clear() {
                super.clear();
                number_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                type_ = 1;
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB
                        .internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber
                    getDefaultInstanceForType() {
                return org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber.getDefaultInstance();
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber build() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber buildPartial() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber result =
                        new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.number_ = number_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.type_ = type_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.setField(field, value);
            }

            public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
                return (Builder) super.clearField(field);
            }

            public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return (Builder) super.clearOneof(oneof);
            }

            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber) {
                    return mergeFrom((org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber other) {
                if (other
                        == org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber
                                .getDefaultInstance()) return this;
                if (other.hasNumber()) {
                    bitField0_ |= 0x00000001;
                    number_ = other.number_;
                    onChanged();
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            public final boolean isInitialized() {
                if (!hasNumber()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber)
                            e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object number_ = "";
            /**
             * <code>required string number = 1;</code>
             */
            public boolean hasNumber() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }
            /**
             * <code>required string number = 1;</code>
             */
            public java.lang.String getNumber() {
                java.lang.Object ref = number_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        number_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }
            /**
             * <code>required string number = 1;</code>
             */
            public com.google.protobuf.ByteString getNumberBytes() {
                java.lang.Object ref = number_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
                    number_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>required string number = 1;</code>
             */
            public Builder setNumber(java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                number_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required string number = 1;</code>
             */
            public Builder clearNumber() {
                bitField0_ = (bitField0_ & ~0x00000001);
                number_ = getDefaultInstance().getNumber();
                onChanged();
                return this;
            }
            /**
             * <code>required string number = 1;</code>
             */
            public Builder setNumberBytes(com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                number_ = value;
                onChanged();
                return this;
            }

            private int type_ = 1;
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
             */
            public boolean hasType() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
             */
            public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType getType() {
                org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType result =
                        org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType.valueOf(type_);
                return result == null
                        ? org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType.HOME
                        : result;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
             */
            public Builder setType(org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                type_ = value.getNumber();
                onChanged();
                return this;
            }
            /**
             * <code>optional .org.apache.dubbo.metadata.definition.protobuf.model.PhoneType type = 2 [default = HOME];</code>
             */
            public Builder clearType() {
                bitField0_ = (bitField0_ & ~0x00000002);
                type_ = 1;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }

            // @@protoc_insertion_point(builder_scope:org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber)
        }

        // @@protoc_insertion_point(class_scope:org.apache.dubbo.metadata.definition.protobuf.model.PhoneNumber)
        private static final org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber();
        }

        public static org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<PhoneNumber> PARSER =
                new com.google.protobuf.AbstractParser<PhoneNumber>() {
                    public PhoneNumber parsePartialFrom(
                            com.google.protobuf.CodedInputStream input,
                            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                            throws com.google.protobuf.InvalidProtocolBufferException {
                        return new PhoneNumber(input, extensionRegistry);
                    }
                };

        public static com.google.protobuf.Parser<PhoneNumber> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<PhoneNumber> getParserForType() {
            return PARSER;
        }

        public org.apache.dubbo.metadata.definition.protobuf.model.GooglePB.PhoneNumber getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor;
    private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        java.lang.String[] descriptorData = {
            "\n\016GooglePB.proto\0223org.apache.dubbo.metad" + "ata.definition.protobuf.model\"\301\004\n\rPBRequ"
                    + "estType\022\r\n\005money\030\001 \001(\001\022\014\n\004cash\030\002 \001(\002\022\013\n\003"
                    + "age\030\003 \001(\005\022\013\n\003num\030\004 \001(\003\022\013\n\003sex\030\005 \001(\010\022\014\n\004n"
                    + "ame\030\006 \001(\t\022\013\n\003msg\030\007 \001(\014\022O\n\005phone\030\010 \003(\0132@."
                    + "org.apache.dubbo.metadata.definition.pro"
                    + "tobuf.model.PhoneNumber\022d\n\tdoubleMap\030\t \003"
                    + "(\0132Q.org.apache.dubbo.metadata.definitio"
                    + "n.protobuf.model.PBRequestType.DoubleMap"
                    + "Entry\022\021\n\tbytesList\030\n \003(\014\022b\n\010bytesMap\030\013 \003",
            "(\0132P.org.apache.dubbo.metadata.definitio" + "n.protobuf.model.PBRequestType.BytesMapE"
                    + "ntry\032r\n\016DoubleMapEntry\022\013\n\003key\030\001 \001(\t\022O\n\005v"
                    + "alue\030\002 \001(\0132@.org.apache.dubbo.metadata.d"
                    + "efinition.protobuf.model.PhoneNumber:\0028\001"
                    + "\032/\n\rBytesMapEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030"
                    + "\002 \001(\014:\0028\001\"~\n\016PBResponseType\022\013\n\003msg\030\001 \001(\t"
                    + "\022_\n\023CDubboPBRequestType\030\003 \001(\0132B.org.apac"
                    + "he.dubbo.metadata.definition.protobuf.mo"
                    + "del.PBRequestType\"q\n\013PhoneNumber\022\016\n\006numb",
            "er\030\001 \002(\t\022R\n\004type\030\002 \001(\0162>.org.apache.dubb"
                    + "o.metadata.definition.protobuf.model.Pho"
                    + "neType:\004HOME*+\n\tPhoneType\022\n\n\006MOBILE\020\000\022\010\n"
                    + "\004HOME\020\001\022\010\n\004WORK\020\0022\247\001\n\017CDubboPBService\022\223\001"
                    + "\n\010sayHello\022B.org.apache.dubbo.metadata.d"
                    + "efinition.protobuf.model.PBRequestType\032C"
                    + ".org.apache.dubbo.metadata.definition.pr"
                    + "otobuf.model.PBResponseType"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
                descriptorData, new com.google.protobuf.Descriptors.FileDescriptor[] {}, assigner);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor,
                        new java.lang.String[] {
                            "Money",
                            "Cash",
                            "Age",
                            "Num",
                            "Sex",
                            "Name",
                            "Msg",
                            "Phone",
                            "DoubleMap",
                            "BytesList",
                            "BytesMap",
                        });
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_descriptor =
                internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor
                        .getNestedTypes()
                        .get(0);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_DoubleMapEntry_descriptor,
                        new java.lang.String[] {
                            "Key", "Value",
                        });
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_descriptor =
                internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_descriptor
                        .getNestedTypes()
                        .get(1);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBRequestType_BytesMapEntry_descriptor,
                        new java.lang.String[] {
                            "Key", "Value",
                        });
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PBResponseType_descriptor,
                        new java.lang.String[] {
                            "Msg", "CDubboPBRequestType",
                        });
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_org_apache_dubbo_metadata_definition_protobuf_model_PhoneNumber_descriptor,
                        new java.lang.String[] {
                            "Number", "Type",
                        });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
