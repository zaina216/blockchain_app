package com.example.anothertest;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class AddressBook extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061077e806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80634ba79dfe1461005157806399900d1114610066578063a39fac121461008f578063d033c456146100a4575b600080fd5b61006461005f3660046104fd565b6100b7565b005b6100796100743660046104fd565b610290565b604051610086919061062e565b60405180910390f35b610097610347565b60405161008691906105e1565b6100646100b236600461051f565b6103b0565b33600090815260208190526040812054905b81811015610279573360009081526020819052604090208054829081106100f2576100f261071c565b6000918252602090912001546001600160a01b038481169116141561027e573360009081526020819052604090205460011080156101395750610136600183610683565b81105b156101cf57336000908152602081905260409020610158600184610683565b815481106101685761016861071c565b600091825260208083209091015433835290829052604090912080546001600160a01b0390921691839081106101a0576101a061071c565b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b031602179055505b3360009081526020819052604090206101e9600184610683565b815481106101f9576101f961071c565b6000918252602080832090910180546001600160a01b03191690553382528190526040902080548061022d5761022d610706565b60008281526020808220830160001990810180546001600160a01b03191690559092019092553382526001815260408083206001600160a01b038716845290915281206102799161040b565b505050565b80610288816106d5565b9150506100c9565b3360009081526001602090815260408083206001600160a01b038516845290915290208054606091906102c29061069a565b80601f01602080910402602001604051908101604052809291908181526020018280546102ee9061069a565b801561033b5780601f106103105761010080835404028352916020019161033b565b820191906000526020600020905b81548152906001019060200180831161031e57829003601f168201915b50505050509050919050565b33600090815260208181526040918290208054835181840281018401909452808452606093928301828280156103a657602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610388575b5050505050905090565b336000818152602081815260408083208054600180820183559185528385200180546001600160a01b0319166001600160a01b0389169081179091559484528252808320938352928152919020825161027992840190610448565b5080546104179061069a565b6000825580601f10610427575050565b601f01602090049060005260206000209081019061044591906104cc565b50565b8280546104549061069a565b90600052602060002090601f01602090048101928261047657600085556104bc565b82601f1061048f57805160ff19168380011785556104bc565b828001600101855582156104bc579182015b828111156104bc5782518255916020019190600101906104a1565b506104c89291506104cc565b5090565b5b808211156104c857600081556001016104cd565b80356001600160a01b03811681146104f857600080fd5b919050565b60006020828403121561050f57600080fd5b610518826104e1565b9392505050565b6000806040838503121561053257600080fd5b61053b836104e1565b9150602083013567ffffffffffffffff8082111561055857600080fd5b818501915085601f83011261056c57600080fd5b81358181111561057e5761057e610732565b604051601f8201601f19908116603f011681019083821181831017156105a6576105a6610732565b816040528281528860208487010111156105bf57600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6020808252825182820181905260009190848201906040850190845b818110156106225783516001600160a01b0316835292840192918401916001016105fd565b50909695505050505050565b600060208083528351808285015260005b8181101561065b5785810183015185820160400152820161063f565b8181111561066d576000604083870101525b50601f01601f1916929092016040019392505050565b600082821015610695576106956106f0565b500390565b600181811c908216806106ae57607f821691505b602082108114156106cf57634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156106e9576106e96106f0565b5060010190565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052603160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052604160045260246000fdfea2646970667358221220c082f0a989cfe4abfbbbe8abbe02300ef19bc703271ba0e131df19288d4bb1e464736f6c63430008060033";

    public static final String FUNC_ADDADDRESS = "addAddress";

    public static final String FUNC_GETADDRESSES = "getAddresses";

    public static final String FUNC_GETALIAS = "getAlias";

    public static final String FUNC_REMOVEADDRESS = "removeAddress";

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addAddress(String addr, String _alias) {
        final Function function = new Function(
                FUNC_ADDADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Utf8String(_alias)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getAddresses() {
        final Function function = new Function(FUNC_GETADDRESSES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<String> getAlias(String addr) {
        final Function function = new Function(FUNC_GETALIAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeAddress(String addr) {
        final Function function = new Function(
                FUNC_REMOVEADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
