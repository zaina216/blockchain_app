package com.example.anothertest;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.anothertest.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private final String PRIVATE_KEY = "664899c672b95434dc0dc6f99baa95701f36d9dfe412d061626d4117ae2e5ffd";
    private final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975);
    private final String RECIPIENT = "0x4764BDd18960a01928ebF44Ea7c5E5157b2090CA";
//    private final String CONTRACT_ADDRESS = "0x22E279B66Bb08a61DF776e765B9519F9FA56673C";
    private final String CONTRACT_ADDRESS = "0x279635563b42541A3372bCf0c75898211A6AE1Bd";
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/292bf993eaf9433594b8926593cfd04c"));
                Credentials credentials = getCredentialsFromPrivateKey();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            String deployedAddr =  deployContract(web3j,credentials);//deployed once; don't deploy again
//                            Log.d(TAG, deployedAddr); //0x279635563b42541A3372bCf0c75898211A6AE1Bd

                            Erc721 nft = loadContract(CONTRACT_ADDRESS, web3j, credentials);

                            Log.d(TAG, nft.balanceOf("0x2412F42C68dDe2Ee49514975d3bEA066B1320723").send().toString());
//                            AddressBook getAddr = loadContract(CONTRACT_ADDRESS, web3j, credentials);
//
//                            Snackbar.make(view, "lontract loaded!!!1111", Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//
//                            addAddresses(getAddr);
//                            printAddresses(getAddr);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();

            }
        });
    }


    private void addAddresses(AddressBook addressBook) throws Exception {
        addressBook
                .addAddress("0x35fEF2216D1426Eb69b3a5BC3F76c62Cb770F360", "joooaaaaoo")
                .send();

    }

    private void printAddresses(AddressBook addressBook) throws Exception {
        for(Object address : addressBook.getAddresses().send()){ //might need sendAsync if waiting for transactions to complete. Ganache is instant tho
            String addressString = address.toString();
            String alias = addressBook.getAlias(addressString).send();
            Log.d(TAG, "address: "+ addressString + " alias: " + alias + "\n");
//            System.out.println("");
        }
    }

    private void printWeb3Version(Web3j web3j){
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert web3ClientVersion != null;
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Web3 client version: " + web3ClientVersionString);
    }

    private Credentials getCredentialsFromWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "passphrase",
                "wallet/path"
        );
    }

    private void transferEth(Web3j web3j, Credentials credentials) throws Exception {

        TransactionManager tm = new RawTransactionManager(
                web3j,
                credentials
        );

        Transfer tf = new Transfer(
                web3j,
                tm
        );

        TransactionReceipt tr = tf.sendFunds(
                RECIPIENT,
                BigDecimal.ONE,
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();


    }

    private Credentials getCredentialsFromPrivateKey(){
        return Credentials.create(PRIVATE_KEY);
    }

    private String deployContract(Web3j web3j, Credentials credentials) throws Exception {
//        return Erc721.deploy(
//                web3j,
//                credentials,
//                GAS_PRICE,
//                GAS_LIMIT).send().getContractAddress();
        return Erc721.deploy(web3j, credentials, new DefaultGasProvider(), "TEST", "PLS").send().getContractAddress();
    }

    private Erc721 loadContract(String deployedAddr, Web3j web3j, Credentials credentials){
        return Erc721.load(deployedAddr, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}