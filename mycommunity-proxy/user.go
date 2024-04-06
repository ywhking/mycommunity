package main

import (
	"context"
	"fmt"
	"log"

	"google.golang.org/grpc"
	"v2ray.com/core/app/proxyman/command"
	"v2ray.com/core/common/protocol"
	"v2ray.com/core/common/serial"
	"v2ray.com/core/proxy/vmess"
)

const (
	API_ADDRESS = "127.0.0.1"
	API_PORT    = 10085
	INBOUND_TAG = "proxy"
	LEVEL       = 0
	ALTERID     = 10
)

func connectProxy(address string, port uint) (command.HandlerServiceClient, error) {
	cmdConn, err := grpc.Dial(fmt.Sprintf("%s:%d", address, port), grpc.WithInsecure())
	if err != nil {
		return nil, err
	}
	hsClient := command.NewHandlerServiceClient(cmdConn)
	return hsClient, nil
}

func addUser(email string, uuid string) error {
	apiClient, err := connectProxy(API_ADDRESS, API_PORT)
	if err != nil {
		log.Printf("failed to call grpc command: %v", err)
		return err
	}
	resp, err := apiClient.AlterInbound(context.Background(), &command.AlterInboundRequest{
		Tag: INBOUND_TAG,
		Operation: serial.ToTypedMessage(&command.AddUserOperation{
			User: &protocol.User{
				Level: LEVEL,
				Email: email,
				Account: serial.ToTypedMessage(&vmess.Account{
					Id:               uuid,
					AlterId:          ALTERID,
					SecuritySettings: &protocol.SecurityConfig{Type: protocol.SecurityType_AUTO},
				}),
			},
		}),
	})
	if err != nil {
		log.Printf("failed to call grpc command: %v", err)
	} else {
		log.Printf("ok: %v", resp)
	}
	return err
}

func removeUser(email string) error {
	apiClient, err := connectProxy(API_ADDRESS, API_PORT)
	if err != nil {
		log.Printf("failed to call grpc command: %v", err)
		return err
	}
	resp, err := apiClient.AlterInbound(context.Background(), &command.AlterInboundRequest{
		Tag: INBOUND_TAG,
		Operation: serial.ToTypedMessage(&command.RemoveUserOperation{
			Email: email,
		}),
	})
	if err != nil {
		log.Printf("failed to call grpc command: %v", err)
	} else {
		log.Printf("ok: %v", resp)
	}
	return err
}
