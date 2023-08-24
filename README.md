# githubAPITask

An API that allows the user to check GitHub repositories for a given user.

# Usage 
After running the application, the API is available at /api?username=[USERNAME]

# Responses
The application responds in JSON format.

When given nonexistent user: 404 status code with "User not found." message.

When the request has an "Accept: application/xml" header: 406 status code with "Request does not produce XML." message.

When the request is correct: A JSON containing all GitHub repositories of input user (not forks), in this format:

- owner: GitHub username
- name: repository name
- branches: JSON Array containing all branches of current repository, the array contains the branch name and latest commit SHA

# Example usage + result

This call: 
```localhost:8080/api?username=rzashakeri```, with an "Accept: application/json" header,

gives this output:
```javascript
{
    "repos": [
        {
            "owner": "rzashakeri",
            "name": "awesome",
            "branches": [
                {
                    "name": "gh-pages",
                    "sha": "7f6610a1d7788df50ff427209d2439f76c772286"
                },
                {
                    "name": "main",
                    "sha": "14874c92be830d4b0fe81290f6f1789157318adb"
                },
                {
                    "name": "patch-1",
                    "sha": "764b03b613b7696cad676c9efa370c282fcf9287"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "awesome-django",
            "branches": [
                {
                    "name": "add-back-logo",
                    "sha": "e499be6fa73246ebd962ec40fb55a34b81ad01f7"
                },
                {
                    "name": "main",
                    "sha": "37011fb84013596e4eb2c2ed533497b9003ca18b"
                },
                {
                    "name": "patch-1",
                    "sha": "bb9b51b874dbbef1aa2007f119e9ebd61f60baed"
                },
                {
                    "name": "pr/52",
                    "sha": "b4484265b5217847501a71be262409b230eb51b8"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "awesome-github-profile-readme",
            "branches": [
                {
                    "name": "master",
                    "sha": "5c3a03886e5a257998dee90de25ccda88a8cf0be"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "awesome-persian",
            "branches": [
                {
                    "name": "master",
                    "sha": "f8dcef81ed39808fe0e574a25d12e77b3bd66679"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "awesome-python",
            "branches": [
                {
                    "name": "gh-pages",
                    "sha": "41d76ecc13eb4ae54ae366cf9c6fe8b06008c5f0"
                },
                {
                    "name": "master",
                    "sha": "2c5758e56ac91b5978549e225453d12985681ca5"
                },
                {
                    "name": "patch-1",
                    "sha": "0fd80a2a5f273ba4a09900218362be75f741b363"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "beautify-github-profile",
            "branches": [
                {
                    "name": "add-code-of-conduct-1",
                    "sha": "25e6cf41fbfb63a8636709efc8dfe62458aa9265"
                },
                {
                    "name": "add-license-1",
                    "sha": "77401a869071ff00b885348bf6d5ed2176e064f0"
                },
                {
                    "name": "master",
                    "sha": "03838dcf8ca12b07eff762e1f78e7bae5c22b49b"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "best-of-ml-python",
            "branches": [
                {
                    "name": "main",
                    "sha": "5759288f0343f1f582e6da1786b1eeda7b1b324d"
                },
                {
                    "name": "update/2021.01.14",
                    "sha": "b9d9c40c5a02c586659f89013207e6df9edc2e15"
                },
                {
                    "name": "update/2021.02.11",
                    "sha": "b42e1239e1b853271a753987b3904a9866057d98"
                },
                {
                    "name": "update/2021.03.18",
                    "sha": "9cfa21883155a4c2906bfedf0a713e641fd38fd6"
                },
                {
                    "name": "update/2021.03.25",
                    "sha": "e6869cae11d89ae8c7f35bb931e2a4d30f6d5686"
                },
                {
                    "name": "update/2021.05.20",
                    "sha": "2c29d3cb814d7b1c40c8504690636bca6eb0d85e"
                },
                {
                    "name": "update/2021.05.27",
                    "sha": "bacb7dd2caa62509f1150d64ee18c6a3fff32e1d"
                },
                {
                    "name": "update/2021.06.10",
                    "sha": "be299406339fe09e3a66806af42e761ecdcc8b61"
                },
                {
                    "name": "update/2021.06.17",
                    "sha": "a45f96610b363dfd70f6ef78f2c6b5a4c6f757ec"
                },
                {
                    "name": "update/2021.06.29-11.50",
                    "sha": "db767dd319293521468eff62f7fe0f9b44f1590c"
                },
                {
                    "name": "update/2021.06.29-14.48",
                    "sha": "a467095708eb99d483dc75f7f3772ded4085fdcd"
                },
                {
                    "name": "update/2021.06.29",
                    "sha": "ba7979f7dd647ac9a0ac16097cb74af403057c3f"
                },
                {
                    "name": "update/2021.07.22",
                    "sha": "37baef05c2a1eda854bc4818ba6766ffca108006"
                },
                {
                    "name": "update/2021.07.29",
                    "sha": "25c6b9475b40420fa2595b14d71acefa23d4235e"
                },
                {
                    "name": "update/2021.08.05",
                    "sha": "912c13b9d74d128576a6dca9d7d466200dda8f4f"
                },
                {
                    "name": "update/2021.08.12",
                    "sha": "581d7eba8ced683d41637ade48adf44639514a37"
                },
                {
                    "name": "update/2021.09.02",
                    "sha": "3aeb92af5e56aa187cbcb456c93d51dc7d6828b5"
                },
                {
                    "name": "update/2021.09.09",
                    "sha": "b994d1cdb9eafa9904e9158689067b0f2dec49b9"
                },
                {
                    "name": "update/2021.09.16",
                    "sha": "fbbeef44aa5b3bd84b497213206ffad372e62da4"
                },
                {
                    "name": "update/2021.09.23",
                    "sha": "dbf9a8beb6f3a2317832a52a8e417702dd7971ed"
                },
                {
                    "name": "update/2021.09.30",
                    "sha": "af43035255e55f866fd951dfada74a275cdeee63"
                },
                {
                    "name": "update/2021.10.07",
                    "sha": "a6499ded14494ecf16f7b5b5d7109d45306551c1"
                },
                {
                    "name": "update/2021.10.14",
                    "sha": "4ecdf3d974761e60dbf6a55c6bee30613eba26dc"
                },
                {
                    "name": "update/2021.10.21",
                    "sha": "8148ccbd2d10a3e37ed4cc53ae2cfbcb5c4e1081"
                },
                {
                    "name": "update/2021.10.28",
                    "sha": "5cb7976d608f4a9dd39f1434f8590cb58a253936"
                },
                {
                    "name": "update/2021.11.04",
                    "sha": "5b18078436a6da9ba7bee83d4b25c4db93aa7eef"
                },
                {
                    "name": "update/2021.11.11",
                    "sha": "0c92fbc655205c5518b6f1dc4bb9209970d914fa"
                },
                {
                    "name": "update/2021.11.18",
                    "sha": "a04874cc97fddebdfe8be685ed6fcc9bfd131463"
                },
                {
                    "name": "update/2021.11.25",
                    "sha": "1ac25ee1948e27c66074c1be1a0767cecbce4f28"
                },
                {
                    "name": "update/2021.12.16",
                    "sha": "11f7071ab82760c0eb3a781af8eebc4b5805de25"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "blog",
            "branches": [
                {
                    "name": "master",
                    "sha": "1e8516c89a94e082269a702d90e26aafbd4eadb4"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "blog-front-end",
            "branches": [
                {
                    "name": "master",
                    "sha": "72097d2ad3ae411b2d615aa99fb708f3c59c872b"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "django",
            "branches": [
                {
                    "name": "main",
                    "sha": "02966a30dd31d2b9d35f8c481a448b9bf377895e"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "django-audio-validator",
            "branches": [
                {
                    "name": "2.0.x",
                    "sha": "8ae0c7e0c250d873a6db89555640f773be59d861"
                },
                {
                    "name": "master",
                    "sha": "c133939cebcc617e516993db17f027369e65c956"
                },
                {
                    "name": "test-branch",
                    "sha": "1806fd1dd382efdd391791045627ca4e2c8f3ca4"
                },
                {
                    "name": "v1",
                    "sha": "377b02f7b956d4586b98a7d9a4a110364d2564dc"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "fa.javascript.info",
            "branches": [
                {
                    "name": "master",
                    "sha": "791ffdfe62a4fc49591e1ad92645b01575cfdfe4"
                },
                {
                    "name": "master-1",
                    "sha": "668bc724b2be87910e1024a8fedb4160f498f56b"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "github-readme-stats",
            "branches": [
                {
                    "name": "add_cache_seconds_env_variable",
                    "sha": "5ea236cfa2434689e8cb9622c49340a8594dfe2a"
                },
                {
                    "name": "add_contribs_translation",
                    "sha": "17a9f7f75602ae1c8301ddc34416fc00fb635bff"
                },
                {
                    "name": "add_missing_tests",
                    "sha": "533fe040a689fe306fcd0054b9e1bf2d9ad104a9"
                },
                {
                    "name": "add_vercel_dev_dependency",
                    "sha": "dca6010ec012f6f14c7f9bfe187974d828ab71e1"
                },
                {
                    "name": "anu/fix-retryer",
                    "sha": "58d2ae6ebf306c40c11f2febe9a375793ab95646"
                },
                {
                    "name": "anu/pat-info-fix",
                    "sha": "8022f5c6b55d99765fbb102eb73cb5acbc5866f9"
                },
                {
                    "name": "anu/svg-snapshots",
                    "sha": "40b95880aea69e251807f085f4661c5851ed0d03"
                },
                {
                    "name": "bulky_lang_card",
                    "sha": "450d095fe48d3c5699ebbed4badd78b0528bc683"
                },
                {
                    "name": "change_error_cache",
                    "sha": "aa2e8ff3c527f705144357df112a191e135fbfc9"
                },
                {
                    "name": "docs_wakatime_user_change",
                    "sha": "4ab959d119458ee79a32d295e9c94b69ac0760f2"
                },
                {
                    "name": "fix_e2e_rank",
                    "sha": "14373a0c4dd628f6469e4997121a1d29e7889e93"
                },
                {
                    "name": "fix_lang_docs",
                    "sha": "44d5c1db8b9463b4905c56d86cacfd3f5dd471fe"
                },
                {
                    "name": "fix_theme_docs_action",
                    "sha": "a640b871c507b8d6b82609412112dbb41285c1ef"
                },
                {
                    "name": "fix_2737",
                    "sha": "42e90ef8861d4c6b7f263bfd00b94bf420cab7fa"
                },
                {
                    "name": "improve_folder_structure",
                    "sha": "147a5d9e2ac45261c21bc649d30523f64c719e57"
                },
                {
                    "name": "improve_readme_links",
                    "sha": "346d003659e056139e00511dcdd844496f279413"
                },
                {
                    "name": "improve_theme_preview_action",
                    "sha": "78d345d30e7df37d4378f829cdde4820d0cc967b"
                },
                {
                    "name": "improve_top_issues_action",
                    "sha": "52868391e21d9f580ddfd6673fd195783168a4e5"
                },
                {
                    "name": "master",
                    "sha": "c96e84a9ae9a095d3787324f84a04f0024145aff"
                },
                {
                    "name": "one_dark_pro_theme",
                    "sha": "6770bd86d7dcdb7119329f84ea8e347f87ba822b"
                },
                {
                    "name": "patch-rank",
                    "sha": "53005a5849ec8e4ad13edbf275355e70338aa24f"
                },
                {
                    "name": "remove_include_private",
                    "sha": "de80dc45675f27eb6faf47282c9263b9c58ef429"
                },
                {
                    "name": "revert-2507-patch-2",
                    "sha": "858fba21d2d1d6ee776c12062d04069dc8fa6a91"
                },
                {
                    "name": "revert-2539-master",
                    "sha": "c15182283979a6f17f4c7a49a608149015e8d04b"
                },
                {
                    "name": "rickstaa-patch-1",
                    "sha": "08da08835967d3efa6b6481222575811099efc88"
                },
                {
                    "name": "test_stale_if_error",
                    "sha": "c504c9338ed830ad619e008ba9ff76422398687f"
                },
                {
                    "name": "test-conflict",
                    "sha": "fbb49e3c80f2c4f84fd86834514bcf9638a011a7"
                },
                {
                    "name": "test-conflict-2",
                    "sha": "8667ea9908b1614352b0b05ed83204942866c059"
                },
                {
                    "name": "theme_preview_batch",
                    "sha": "6883fec5c7f0c7aaa94d645ac8a8ad86fd235ff8"
                },
                {
                    "name": "ts_migration_base",
                    "sha": "c624fe9507e2a20eb2b11b9fc968485e53bc2443"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "gpt4free",
            "branches": [
                {
                    "name": "add-license-1",
                    "sha": "ed6fbc5f3acccf08b0f4fa6ec1f53abe7a338529"
                },
                {
                    "name": "main",
                    "sha": "3f49f18e070216d73030385cf45a602a7e172a44"
                },
                {
                    "name": "revert-29-patch-1",
                    "sha": "69593b77b1bdd2f20d1275a64326d6abc92082e7"
                },
                {
                    "name": "upate-readme",
                    "sha": "f42ed825a0686be99d4abb4c62b57e4fc9f80f05"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "gpt4free-python-package",
            "branches": [
                {
                    "name": "master",
                    "sha": "3fee3d534da5270e7dc09172a01a19d6effb41fd"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "Happier",
            "branches": [
                {
                    "name": "master",
                    "sha": "83f0a7065c56eaad183efb97de058a96d4821a96"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "Instagram-Assistant",
            "branches": [
                {
                    "name": "develop",
                    "sha": "fc8edf0401e3e67100e08928c32ed257a7791da0"
                },
                {
                    "name": "docs",
                    "sha": "c7b87f09af31e65eba81773c6d1294470d2576a7"
                },
                {
                    "name": "master",
                    "sha": "9bd04c9f1326ceca5df3048ececd48526d2e4a02"
                },
                {
                    "name": "restyled/develop",
                    "sha": "08504f44a43f60b30c531e5b68b354539c262d05"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "instagram-getter",
            "branches": [
                {
                    "name": "main",
                    "sha": "436b868fe60321f7ac02b4069c78cc4e83b3d357"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "instagrapi",
            "branches": [
                {
                    "name": "adding-reel-with-music",
                    "sha": "32e65c6047be1ed13ea7c3c58ed400b5e7a12c09"
                },
                {
                    "name": "custom_validator_instead_pydantic",
                    "sha": "8d9ed9b8385f7692eb8e50876585d84238ec68f9"
                },
                {
                    "name": "dependabot/pip/mkdocs-material-9.1.9",
                    "sha": "87cf926f7625d83ad308ea420bd35fd98ec0bd5b"
                },
                {
                    "name": "dependabot/pip/requests-2.30.0",
                    "sha": "bcb4211a879fe41dce3cef24c0b494b2ca200021"
                },
                {
                    "name": "master",
                    "sha": "52438ed05e415140523d29d6f1517a774a9f1e90"
                },
                {
                    "name": "patch-1",
                    "sha": "f449fec7ac9c6db9f4dbf715e460bb22464d2962"
                },
                {
                    "name": "signup",
                    "sha": "7b92a39e00cd22a9cac7cb8b85b23bb00692b67d"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "Lorem-Farsi",
            "branches": [
                {
                    "name": "main",
                    "sha": "ffaf4dc779faf49306f6c2227f792155c95584ad"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "messaging-chat-app-system-design",
            "branches": [
                {
                    "name": "master",
                    "sha": "700273fc0ffa57da7d99b0708a4dbc0fc485ff8c"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "pycharm-portfolio",
            "branches": [
                {
                    "name": "master",
                    "sha": "41423d340f7d215b681e66f69de5463415a24940"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "pycharm-portfolio-cookiecutter",
            "branches": [
                {
                    "name": "dependabot/pip/django-4.2.4",
                    "sha": "afd8f146647374676a60f2dfda575df2a44862ee"
                },
                {
                    "name": "dependabot/pip/pytest-7.4.0",
                    "sha": "974f8d7075b33da219de5d79f2c12901b404576e"
                },
                {
                    "name": "dependabot/pip/sphinx-7.2.3",
                    "sha": "1cfc55d9e3e0a6134270bd9d205c7b861bdd9fd3"
                },
                {
                    "name": "dependabot/pip/werkzeug-watchdog--2.3.7",
                    "sha": "294d496eca69400f4d73b33740521135b885d35d"
                },
                {
                    "name": "dependabot/pip/whitenoise-6.5.0",
                    "sha": "c3d87d3277f3bb4c3d6a021eb416ee0aa90b4b6e"
                },
                {
                    "name": "master",
                    "sha": "3e6c65e4a4608217fc490b902c66e846df7a1c20"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "pycharm-portfolio-theme",
            "branches": [
                {
                    "name": "master",
                    "sha": "5534ed9050170dea80e6aeeadbb0b11afe66bc89"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "python-telegram-bot-seed",
            "branches": [
                {
                    "name": "develop",
                    "sha": "bb699fb20a09ae311de92ad5667caefe122a5627"
                },
                {
                    "name": "master",
                    "sha": "2a11777ded3857574f66a222f7196f4c9fbe1e68"
                },
                {
                    "name": "patch-1",
                    "sha": "3d99c034224ca45f42c9f8104f326970c2c59483"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "rezashakeri",
            "branches": []
        },
        {
            "owner": "rzashakeri",
            "name": "rzashakeri",
            "branches": [
                {
                    "name": "Grammarly-Bot-Fixes",
                    "sha": "37e819d5b6ca3713e56c1a676d2cb519a3197f74"
                },
                {
                    "name": "main",
                    "sha": "274f684c8a2fdb1571b7ff65e220668fd79e47a8"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "Telegram-Bot",
            "branches": [
                {
                    "name": "master",
                    "sha": "6165b248abc95549e39eb591e25758540738cfd9"
                }
            ]
        },
        {
            "owner": "rzashakeri",
            "name": "telegram-bot-template",
            "branches": [
                {
                    "name": "master",
                    "sha": "09b30bf5d02158c539c81e5e513bae0dc13a891d"
                }
            ]
        }
    ],
        "status": 200
}
```
